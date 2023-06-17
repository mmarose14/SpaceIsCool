package com.spaceiscool.neo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.spaceiscool.base.BaseFragment
import com.spaceiscool.data.model.neo.NEO
import com.spaceiscool.data.model.neo.NearEarthObject
import com.spaceiscool.databinding.FragmentNeoBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NEOFragment: BaseFragment(), NEOAdapter.NEOListener {
    private var _binding: FragmentNeoBinding? = null
    private val binding get() = _binding!!

    private val neoViewModel: NEOViewModel by viewModels()
    private var neoAdapter: NEOAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNeoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupView()
    }

    private fun setupView() {
        neoViewModel.errorMessage.observe(viewLifecycleOwner) { errorMessage ->
            binding.emptyView.visibility = View.VISIBLE
            binding.emptyView.text = errorMessage

        }

        neoViewModel.neo.observe(viewLifecycleOwner) { neo ->
            binding.emptyView.visibility = View.GONE
            updateList(neo)
        }

        binding.apply {
            neoAdapter = NEOAdapter()
            neoAdapter?.listener = this@NEOFragment
            neoRecyclerView.adapter = neoAdapter
            neoRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        }

        neoViewModel.getNeoBrowse()
    }

    private fun updateList(neo: NEO) {
        neoAdapter?.submitList(neo.near_earth_objects)
    }

    override fun onNEOClicked(neo: NearEarthObject) {
        val url = neoViewModel.getNeoURL(neo)
        displayInBrowser(url)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
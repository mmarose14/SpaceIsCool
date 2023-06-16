package com.spaceiscool.pictureoftheday

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.spaceiscool.R
import com.spaceiscool.base.BaseFragment
import com.spaceiscool.data.APOD
import com.spaceiscool.databinding.FragmentApodBinding
import com.spaceiscool.main.APODViewModel
import com.squareup.picasso.Picasso

class APODFragment: BaseFragment() {
    private var _binding: FragmentApodBinding? = null
    private val binding get() = _binding!!

    private val APODViewModel: APODViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentApodBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        APODViewModel.apod.observe(viewLifecycleOwner) { apod ->
            showAPOD(apod)
        }

        APODViewModel.errorMessage.observe(viewLifecycleOwner) { errorMessage ->
            //TODO: Display error
        }

        APODViewModel.getPhotoOfTheDay()
    }

    private fun showAPOD(apod: APOD) {
        binding.apply {
            apodTitle.text = apod.title
            apodDescription.text = apod.explanation

            apodImage.setOnClickListener {
                displayPhotoInBrowser(apod.url)
            }
        }

        Picasso.get()
            .load(apod.url)
            .placeholder(R.drawable.mars_default)
            .into(binding.apodImage)

    }
}
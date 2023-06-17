package com.spaceiscool.data.model.neo

data class NEO(
    val near_earth_objects: List<NearEarthObject>,
    val page: Page
)

data class Page(
    val number: Int,
    val size: Int,
    val total_elements: Int,
    val total_pages: Int
)
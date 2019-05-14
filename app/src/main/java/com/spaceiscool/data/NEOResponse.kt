package com.spaceiscool.data

data class NEOResponse(
    val links: NearEarthObjectFull.Links,
    val near_earth_objects: List<NearEarthObjectFull.NearEarthObject>,
    val page: NearEarthObjectFull.Page
)
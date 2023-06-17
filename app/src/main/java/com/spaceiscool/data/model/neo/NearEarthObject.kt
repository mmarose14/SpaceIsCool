package com.spaceiscool.data.model.neo

data class NearEarthObject(
    val absolute_magnitude_h: Double,
    val close_approach_data: List<CloseApproachData>,
    val designation: String,
    val estimated_diameter: EstimatedDiameter,
    val id: String,
    val is_potentially_hazardous_asteroid: Boolean,
    val is_sentry_object: Boolean,
    val links: Link,
    val name: String,
    val name_limited: String,
    val nasa_jpl_url: String,
    val neo_reference_id: String,
    val orbital_data: OrbitalData
)

data class Link(
    val self: String
)

data class EstimatedDiameter(
    val feet: Map<String, String>,
    val kilometers: Map<String, String>,
    val meters: Map<String, String>,
    val miles: Map<String, String>
)

data class CloseApproachData(
    val close_approach_date: String,
    val close_approach_date_full: String,
    val epoch_date_close_approach: Long,
    val orbiting_body: String,
)
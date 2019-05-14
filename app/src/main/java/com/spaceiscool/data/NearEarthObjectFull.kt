package com.spaceiscool.data

data class NearEarthObjectFull(
    val links: Links,
    val near_earth_objects: List<NearEarthObject>,
    val page: Page
) {
    data class Page(
        val number: Int,
        val size: Int,
        val total_elements: Int,
        val total_pages: Int
    )

    data class NearEarthObject(
        val absolute_magnitude_h: Double,
        val close_approach_data: List<CloseApproachData>,
        val designation: String,
        val estimated_diameter: EstimatedDiameter,
        val is_potentially_hazardous_asteroid: Boolean,
        val is_sentry_object: Boolean,
        val links: Links,
        val name: String,
        val name_limited: String,
        val nasa_jpl_url: String,
        val neo_reference_id: String,
        val orbital_data: OrbitalData,
        val sentry_data: String
    ) {
        data class OrbitalData(
            val aphelion_distance: String,
            val ascending_node_longitude: String,
            val data_arc_in_days: Int?,
            val eccentricity: String,
            val epoch_osculation: String,
            val equinox: String,
            val first_observation_date: String,
            val inclination: String,
            val jupiter_tisserand_invariant: String,
            val last_observation_date: String,
            val mean_anomaly: String,
            val mean_motion: String,
            val minimum_orbit_intersection: String,
            val observations_used: Int,
            val orbit_class: OrbitClass,
            val orbit_determination_date: String,
            val orbit_id: String,
            val orbit_uncertainty: String,
            val orbital_period: String,
            val perihelion_argument: String,
            val perihelion_distance: String,
            val perihelion_time: String,
            val semi_major_axis: String
        ) {
            data class OrbitClass(
                val orbit_class_description: String,
                val orbit_class_range: String,
                val orbit_class_type: String
            )
        }

        data class CloseApproachData(
            val close_approach_date: String,
            val epoch_date_close_approach: Long,
            val miss_distance: MissDistance,
            val orbiting_body: String,
            val relative_velocity: RelativeVelocity
        ) {
            data class MissDistance(
                val astronomical: String,
                val kilometers: String,
                val lunar: String,
                val miles: String
            )

            data class RelativeVelocity(
                val kilometers_per_hour: String,
                val kilometers_per_second: String,
                val miles_per_hour: String
            )
        }

        data class EstimatedDiameter(
            val feet: Feet,
            val kilometers: Kilometers,
            val meters: Meters,
            val miles: Miles
        ) {
            data class Feet(
                val estimated_diameter_max: Double,
                val estimated_diameter_min: Double
            )

            data class Kilometers(
                val estimated_diameter_max: Double,
                val estimated_diameter_min: Double
            )

            data class Miles(
                val estimated_diameter_max: Double,
                val estimated_diameter_min: Double
            )

            data class Meters(
                val estimated_diameter_max: Double,
                val estimated_diameter_min: Double
            )
        }
    }

    data class Links(
        val next: String,
        val self: String
    )
}
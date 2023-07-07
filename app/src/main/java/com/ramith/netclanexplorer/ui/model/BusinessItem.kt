package com.ramith.netclanexplorer.ui.model

data class BusinessItem(
    var businessName: String,
    var cityName: String,
    var lowerDistanceRange: Int,
    var upperDistanceRange: Int,
    var distance: Float,
    var progress: Int,
    var purposes: ArrayList<Int>,
    var profession: String,
    var experience: Int,
    var about: String,
)

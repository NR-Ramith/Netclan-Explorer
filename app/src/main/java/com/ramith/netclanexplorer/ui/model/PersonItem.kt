package com.ramith.netclanexplorer.ui.model

data class PersonItem(
    var personName: String,
    var cityName: String,
    var profession: String,
    var lowerDistanceRange: Int,
    var upperDistanceRange: Int,
    var distance: Float,
    var progress: Int,
    var purposes: ArrayList<String>,
    var status: String
)

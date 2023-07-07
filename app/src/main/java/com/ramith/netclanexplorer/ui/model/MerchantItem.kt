package com.ramith.netclanexplorer.ui.model

data class MerchantItem(
    var merchantName: String,
    var cityName: String,
    var lowerDistanceRange: Int,
    var upperDistanceRange: Int,
    var distance: Float,
    var progress: Int,
    var purposes: ArrayList<Int>,
    var about: String,
    var service: String
)

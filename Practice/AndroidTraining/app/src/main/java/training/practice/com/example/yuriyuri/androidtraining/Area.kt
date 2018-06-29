package training.practice.com.example.yuriyuri.androidtraining

import com.google.gson.annotations.SerializedName

data class Area(
        @SerializedName("code")
        var areaCd: String,
        @SerializedName("name")
        var areaName: String
)
package training.practice.com.example.yuriyuri.androidtraining

import com.google.gson.annotations.SerializedName

data class Stock(
        @SerializedName("title")
        var bookTitle: String,
        var author: String,
        @SerializedName("number")
        var stockNumber: String?
)
package training.practice.com.example.yuriyuri.androidtraining

import com.google.gson.annotations.SerializedName

data class BookStore(
        @SerializedName("shop_name")
        var shopName: String,
        @SerializedName("shop_cd")
        var shopCd: String,
        var area: Area,
        @SerializedName("stock")
        var stockList: List<Stock>
)
package sampleapp.practice.com.example.yuriyuri.model

data class TagId(var value: String) {
    init {
        if (value.isEmpty()) {
            throw IllegalStateException("TagId is must not null!!")
        }
    }
}
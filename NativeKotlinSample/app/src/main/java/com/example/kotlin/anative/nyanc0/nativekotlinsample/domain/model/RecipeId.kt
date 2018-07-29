package com.example.kotlin.anative.nyanc0.nativekotlinsample.domain.model

import android.os.Parcel
import android.os.Parcelable

data class RecipeId(var value: String) : Parcelable {
    init {
        if (value.isEmpty()) {
            throw IllegalStateException("RecipeId is must not null!!")
        }
    }

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(value)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<RecipeId> = object : Parcelable.Creator<RecipeId> {
            override fun createFromParcel(source: Parcel): RecipeId {
                return RecipeId(source.readString())
            }

            override fun newArray(size: Int): Array<RecipeId?> {
                return arrayOfNulls(size)
            }
        }
    }
}
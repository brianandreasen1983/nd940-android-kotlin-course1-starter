package com.udacity.shoestore.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
// TODO: Size should be in double
@Parcelize
data class Shoe(var name: String,
                var size: String,
                var company: String,
                var description: String,
                val images: List<String> = mutableListOf()) : Parcelable
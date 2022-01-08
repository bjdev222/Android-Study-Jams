package com.scetasj.universitydatabase.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Staff(
    val iUrl:String,
    val bio: String,
    val name: String
):Parcelable

package com.scetasj.universitydatabase.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "proffesor")
data class Info(
    @PrimaryKey(autoGenerate = true) var userId: Int? = null,
    val dept: String,
    val staff:List<Staff>
):Parcelable


//@Entity(tableName = "proffesor")
//data class Info(
//    @PrimaryKey(autoGenerate = true) var userId: Int? = null,
//    val name: String,
//    var bio: String,
//    var department: String
//)
package com.example.pawpics.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "dogs")
data class Dog(
    @PrimaryKey
    val id: String,
    val name: String?,
    @SerializedName("reference_image_id")
    val imageId: String?,
    val cfa_url: String?,
    val temperament: String?,
    val origin: String?,
    val description: String?,
    val life_span: String?
)

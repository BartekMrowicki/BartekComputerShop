package com.example.bartekcomputershop.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class PartDatabase(
    @PrimaryKey val uid: Int?,
    @ColumnInfo val title: String,
    @ColumnInfo val Price: Double
)
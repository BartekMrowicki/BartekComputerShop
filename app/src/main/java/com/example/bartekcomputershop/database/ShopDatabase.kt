package com.example.bartekcomputershop.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [PartDatabase::class], version = 1)
abstract class ShopDatabase : RoomDatabase() {
    abstract fun PartsDao(): PartsDao
}
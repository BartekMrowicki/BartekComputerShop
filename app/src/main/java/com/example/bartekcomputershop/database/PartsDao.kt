package com.example.bartekcomputershop.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface PartsDao {

    @Query("SELECT * FROM PartDatabase")
    fun getAll(): List<PartDatabase>

    @Query("SELECT * FROM PartDatabase WHERE title LIKE :term")
   fun searchFor(term: String): List<PartDatabase>



    @Insert
    fun insertAll(vararg users: PartDatabase)

}
package com.hdsturkey.yalovabsm404.firstassignment.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hdsturkey.yalovabsm404.firstassignment.data.model.OrderDetail

@Dao
interface OrderDetailDao {
    @Query("SELECT * FROM OrderDetail")
    fun getAll(): LiveData<List<OrderDetail>>

    @Query("SELECT * FROM OrderDetail")
    fun getAllOneShot(): List<OrderDetail>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(user: OrderDetail)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: List<OrderDetail>)

    @Delete
    suspend fun delete(user: OrderDetail)

    @Query("DELETE FROM OrderDetail")
    suspend fun deleteAll()


}
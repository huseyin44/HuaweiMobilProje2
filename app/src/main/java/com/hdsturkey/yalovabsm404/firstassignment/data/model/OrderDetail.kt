package com.hdsturkey.yalovabsm404.firstassignment.data.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class OrderDetail(
    @ColumnInfo(name="name") val name:Products,
    @ColumnInfo(name="options") val options:Products,
    @ColumnInfo(name="price") val price:Products,
    @ColumnInfo(name="note") val note:Products,
    @ColumnInfo(name="piece") val piece:Products,
    @ColumnInfo(name="image") val image:Products,
    @PrimaryKey(autoGenerate = true) val userId: Int = 0 // Each Room entity must define a primary key that uniquely identifies each row in the corresponding database table.
)

package com.hdsturkey.yalovabsm404.firstassignment.fragments.order_detail

import android.util.Log
import androidx.lifecycle.liveData
import com.hdsturkey.yalovabsm404.firstassignment.data.local.AppDatabase
import com.hdsturkey.yalovabsm404.firstassignment.data.model.OrderDetail
import com.hdsturkey.yalovabsm404.firstassignment.util.NetworkHelper

class OrderDetailRepository {
    suspend fun getUsers(orderCount: Int) = liveData {
        val storedUsers = AppDatabase.getInstance().OrderDetailDao().getAll()
        emitSource(storedUsers)


        val remoteOrders = NetworkHelper.getServices().getOrderList(orderCount).results
        if (remoteOrders.isNullOrEmpty().not()) {
            AppDatabase.getInstance().OrderDetailDao().insert(remoteOrders)
        } else {
            Log.e("UserListRepository", "Fetching user list from remote failed. Local user list will shown.")
        }
    }

    suspend fun saveUser(OrderDetail: OrderDetail) {
        AppDatabase.getInstance().OrderDetailDao().insert(OrderDetail)
    }
}
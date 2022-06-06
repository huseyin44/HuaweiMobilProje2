package com.hdsturkey.yalovabsm404.firstassignment.fragments.order_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hdsturkey.yalovabsm404.firstassignment.data.model.OrderDetail
import kotlinx.coroutines.launch

class OrderDetailViewModel : ViewModel() {

    private val userListRepository = OrderDetailRepository()

    fun getOrderDetail(userCount: Int): LiveData<List<OrderDetail>> {
        var OrderDetailListLiveData: LiveData<List<OrderDetail>> = MutableLiveData(emptyList())

        viewModelScope.launch {
            OrderDetailListLiveData = userListRepository.getUsers(userCount)
        }

        return OrderDetailListLiveData
    }
}
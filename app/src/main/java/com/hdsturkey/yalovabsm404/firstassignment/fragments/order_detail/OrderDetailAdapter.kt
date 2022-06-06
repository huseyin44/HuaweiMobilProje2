package com.hdsturkey.yalovabsm404.firstassignment.fragments.order_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.hdsturkey.yalovabsm404.firstassignment.data.model.OrderDetail
import com.hdsturkey.yalovabsm404.firstassignment.databinding.ItemOrderDetailBinding

class OrderDetailAdapter  : ListAdapter<OrderDetail, OrderDetailAdapter.UserViewHolder>(UserDiffCallBack()){

    class UserViewHolder(private val mBinding: ItemOrderDetailBinding) : RecyclerView.ViewHolder(mBinding.root) {


        companion object {
            fun from(parent: ViewGroup): UserViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemOrderDetailBinding.inflate(layoutInflater,parent,false) // //R.layout.item_user
                return UserViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder.from(parent)
    }

    override fun onBindViewHolder(userViewHolder: UserViewHolder, position: Int) {
        val item = getItem(position)

    }

    private class UserDiffCallBack : DiffUtil.ItemCallback<OrderDetail>() {
        override fun areItemsTheSame(oldItem: OrderDetail, newItem: OrderDetail) = oldItem.userId == newItem.userId

        override fun areContentsTheSame(oldItem: OrderDetail, newItem: OrderDetail) = oldItem == newItem
    }

}
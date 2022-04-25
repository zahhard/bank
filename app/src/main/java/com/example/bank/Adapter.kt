package com.example.bank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(var dataList: ArrayList<AccountEntity>) :
    RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvAccountNumber: TextView = view.findViewById(R.id.tv_account_num)
        val tvBalance: TextView = view.findViewById(R.id.tv_balance)
        val tvAccountType: TextView = view.findViewById(R.id.tv_account_type)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_recyclerview, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvAccountNumber.text = dataList[position].accountNumber.toString()
        holder.tvAccountType.text = dataList[position].accountType
        holder.tvBalance.text = dataList[position].balance
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

}
package com.example.bank

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class WithdrawMoneyAdapter(private val postList: List<TransActionData>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.transactions, parent, false)
        return CustomAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        val ItemsViewModel = postList[position]
        var card1 = Card("1", BankName.Mellat, "Zahra")
        var card2 = Card("2", BankName.Keshavarzi, "Vahid")
        var transActionData = TransActionData(card1, card2)
        holder.textView.text = transActionData.getName()
    }

    override fun getItemCount() = postList.size


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textView: TextView = itemView.findViewById(R.id.tv_bank_name1)
    }
}

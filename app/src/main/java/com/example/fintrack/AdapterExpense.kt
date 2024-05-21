package com.example.fintrack

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fintrack.data.model.Expense

class AdapterExpense: ListAdapter<Expense, AdapterExpense.ExpenseViewHolder>(ExpenseDiffutils()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_expense, parent, false)
            return ExpenseViewHolder(view)
    }
    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = getItem(position)
        holder.bind(expense)
    }

    class ExpenseViewHolder(view: View) : RecyclerView.ViewHolder(view){
        private val title = view.findViewById<TextView>(R.id.title_expense)
        private val valor = view.findViewById<TextView>(R.id.valor_expense)
        private val image = view.findViewById<ImageView>(R.id.image_expense)

        fun bind(expense: Expense){
            title.text = expense.nameExpense
            valor.text = expense.price.toString()
        }
    }

    class ExpenseDiffutils : DiffUtil.ItemCallback<Expense>(){
        override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem.nameExpense == newItem.nameExpense
                    && oldItem.price == newItem.price
        }

    }
}
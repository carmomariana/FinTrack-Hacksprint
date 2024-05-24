package com.example.fintrack

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fintrack.data.model.Expense
import com.example.fintrack.databinding.ItemExpenseBinding

class AdapterExpense : ListAdapter<Expense, AdapterExpense.ExpenseViewHolder>(DIFF_CALLBACK) {

    private lateinit var onClick: (Expense) -> Unit

    class ExpenseViewHolder(private val binding: ItemExpenseBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(expense: Expense, onClick: (Expense) -> Unit) {
            binding.titleExpense.text = expense.nameExpense
            binding.valorExpense.text = expense.price.toString()
            binding.imageExpense.setImageResource(expense.iconExpense)
            binding.imageColor.setImageResource(expense.imageColor)
            onClick.invoke(expense)
        }
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Expense>() {
            override fun areItemsTheSame(
                oldItem: Expense,
                newItem: Expense
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: Expense,
                newItem: Expense
            ): Boolean {
                return when {
                    oldItem.id != newItem.id -> {
                        false
                    }

                    oldItem.nameExpense != newItem.nameExpense -> {
                        false
                    }

                    oldItem.price != newItem.price -> {
                        false
                    }

                    oldItem.iconExpense != newItem.iconExpense -> {
                        false
                    }

                    else -> true
                }
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterExpense.ExpenseViewHolder {
        return ExpenseViewHolder(
            ItemExpenseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun setOnClickItem(click: (Expense) -> Unit) {
        onClick = click
    }

    override fun onBindViewHolder(holder: AdapterExpense.ExpenseViewHolder, position: Int) {
        val expense = getItem(position)
        holder.bind(expense, onClick)
    }

}
package com.example.fintrack

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.fintrack.data.db.AppDatabase
import com.example.fintrack.data.db.entity.CategoryEntity
import com.example.fintrack.data.model.CategoryUiData
import com.example.fintrack.data.model.Expense
import com.example.fintrack.databinding.ActivityMainBinding
import com.example.fintrack.repository.ExpenseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var expenseAdapter: AdapterExpense

    private val db by lazy {
        Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "category.db, expense.db"
        ).build()
    }

    private val categoryDao by lazy {
        db.CategoryDao()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initRecyclerView()
        initListener()
    }
    private fun initRecyclerView() {
        expenseAdapter = AdapterExpense()
        expenseAdapter.setOnClickItem { expense ->
//            val intent = Intent(this, ClasseEdit::class.java)
//            intent.putExtra("name", expense.nameExpense)
//            intent.putExtra("imageColor", expense.imageColor)
//            intent.putExtra("category", expense.category)
//            intent.putExtra("iconExpense", expense.iconExpense)
//            intent.putExtra("price", expense.price)

            //Codigo para receber as informações na outra tela.
            // val nameExpense = intent.getStringExtra("name")
            //val imageColor = intent.getIntExtra("imageColor", R.color.white)
            //val category = intent.getStringExtra("category")
            //val iconExpense = intent.getIntExtra("iconExpense", R.drawable.ic_launcher_background)
            //val price = intent.getIntExtra("price", 0)

            startActivity(intent)
        }

        with(binding.rvExpense) {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = expenseAdapter

        }
        val rvCategories = binding.rvCategories
        val categoryAdapter = CategoryListAdapter()

        categoryAdapter.setOnClickListener { selected ->
            val categoryTemp = categories.map { item ->
                when {
                    item.nameCategory == selected.nameCategory && !item.isSelect -> item.copy(isSelect = true)
                    item.nameCategory == selected.nameCategory && item.isSelect -> item.copy(isSelect = false)
                    else -> item
                }
            }

            val taskTemp =
                if (selected.nameCategory != "ALL") {
                    tasks.filter { it.nameExpense == selected.nameCategory }
                } else {
                    tasks
                }
            expenseAdapter.submitList(taskTemp)

            categoryAdapter.submitList(categoryTemp)
        }

        rvCategories.adapter = categoryAdapter
        categoryAdapter.submitList(categories)
    }
    private fun initListener() {
        binding.buttonAdd.setOnClickListener {
            startActivity(Intent(this, DespesaActivity::class.java))

        }
    }
    private fun insertDefaultCategory(){
        val categoriesEntity = categories.map{
            CategoryEntity(
                nameCategory = it.nameCategory,
                colorCategory = it.colorCategory,
                iconCategory = it.iconCategory,
                isSelect = it.isSelect
            )
        }
        GlobalScope.launch(Dispatchers.IO) {
            categoryDao.insertAll(categoriesEntity)
        }
    }
}

val categories = listOf(
    CategoryUiData(
        nameCategory = "ALL",
        isSelect = false,
        colorCategory = R.color.white,
        iconCategory = R.drawable.ic_car
    ),
    CategoryUiData(
        nameCategory = "STUDY",
        isSelect = false,
        colorCategory = R.color.white,
        iconCategory = R.drawable.ic_key
    ),
    CategoryUiData(
        nameCategory = "WORK",
        isSelect = false,
        colorCategory = R.color.white,
        iconCategory = R.drawable.ic_key
    )
)

val tasks = listOf(
    Expense(
        nameExpense = "Aluguel",
        imageColor = R.color.pink,
        category = "STUDIO",
        iconExpense = R.drawable.ic_key,
        price = 100.0
    ),
    Expense(
        nameExpense = "Aluguel",
        imageColor = R.color.pink,
        category = "STUDIO",
        iconExpense = R.drawable.ic_key,
        price = 100.0
    ),
    Expense(
        nameExpense = "Aluguel",
        imageColor = R.color.pink,
        category = "STUDIO",
        iconExpense = R.drawable.ic_key,
        price = 100.0
    )

)
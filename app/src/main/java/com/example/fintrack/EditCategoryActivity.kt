package com.example.fintrack

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fintrack.data.db.entity.CategoryEntity
import com.example.fintrack.data.db.entity.ExpenseEntity
import com.example.fintrack.databinding.ActivityEditCategoryBinding
import com.google.android.material.textfield.MaterialAutoCompleteTextView
import java.util.Locale


class EditCategoryActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditCategoryBinding
    private lateinit var adapter: CategoryListAdapter
    private val categoryList = mutableListOf<CategoryEntity>()
    private var selectedCategory: Locale.Category? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = arrayOf("Todos", "Casa", "Carro", "Alimentação", "Transporte", "Educação", "Lazer", "Energia", "Saúde", "Shopping", "Pets", "Outros")
        (binding.textFieldeditCategory.editText as? MaterialAutoCompleteTextView)?.setSimpleItems(items)

        // Lidando com o clique dos botões
        binding.btnDelete.setOnClickListener {

        }

        binding.btnUptade.setOnClickListener {
            val nameExpense = intent.getStringExtra("name")
            val imageColor = intent.getIntExtra("imageColor", R.color.white)
            val category = intent.getStringExtra("category")
            val iconExpense = intent.getIntExtra("iconExpense", R.drawable.ic_launcher_background)
            val price = intent.getIntExtra("price", 0)
        }


    }

}

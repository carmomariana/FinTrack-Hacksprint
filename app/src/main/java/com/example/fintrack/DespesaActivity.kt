package com.example.fintrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar

class DespesaActivity : AppCompatActivity() {

    //  private lateinit var binding: ActivityDespesaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_despesa)

        val edtDespesa = findViewById<EditText>(R.id.edtDespesa)
        val recCategory = findViewById<RecyclerView>(R.id.tvCategoria)
        val edtPrice = findViewById<EditText>(R.id.edtPrice)
        val btnCreate = findViewById<Button>(R.id.btnSave)

        btnCreate.setOnClickListener {

            val StrDepesa: String = edtDespesa.text.toString()
            val StrPrice: String = edtPrice.text.toString()
            val StrCategory: String = recCategory.toString()

            if (StrDepesa.isBlank() || StrPrice.isBlank()|| StrCategory.isBlank()) {
                Snackbar.make(edtDespesa, "Preencha todos os campos! ", Snackbar.LENGTH_LONG)
                    .show()
            } else {

                val Despesa = edtDespesa.text
                val Price = edtPrice.text
                val Categoria = recCategory.toString()

                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("KEY_DESPESA", Despesa)
                intent.putExtra("KEY_PRICE", Price)
                intent.putExtra("KEY_CATEGORIA", Categoria)
                startActivity(intent)
            }
        }
    }
}
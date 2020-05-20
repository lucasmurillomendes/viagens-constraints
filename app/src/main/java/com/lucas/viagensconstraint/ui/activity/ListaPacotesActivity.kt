package com.lucas.viagensconstraint.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.lucas.viagensconstraint.R
import com.lucas.viagensconstraint.dao.PacoteDAO
import com.lucas.viagensconstraint.ui.adapter.ListaPacotesAdapter
import kotlinx.android.synthetic.main.activity_lista_pacotes.*

class ListaPacotesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacotes)

        title = getString(R.string.titulo_activity)

        setupListView()
    }

    private fun setupListView() {
        val lista = PacoteDAO().lista()
        with(lista_pacotes_listView) {
            adapter = ListaPacotesAdapter(lista, this@ListaPacotesActivity)
        }
    }
}

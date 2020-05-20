package com.lucas.viagensconstraint.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.lucas.viagensconstraint.R
import com.lucas.viagensconstraint.extensions.formataDias
import com.lucas.viagensconstraint.extensions.formatoBrasileiro
import com.lucas.viagensconstraint.model.Pacote

class ListaPacotesAdapter(
    private val listaPacotes: List<Pacote>,
    private val context: Context
) : BaseAdapter() {
    @SuppressLint("SetTextI18n", "ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false)

        val pacote = listaPacotes[position]

        setupLocal(viewCriada, pacote)

        setupImage(viewCriada, pacote)

        setupDias(viewCriada, pacote)

        setupPreco(viewCriada, pacote)

        return viewCriada
    }

    private fun setupPreco(viewCriada: View, pacote: Pacote) {
        val preco = viewCriada.findViewById<TextView>(R.id.item_pacote_preco)
        preco.text = pacote.preco.formatoBrasileiro()
    }

    private fun setupDias(viewCriada: View, pacote: Pacote) {
        val dias = viewCriada.findViewById<TextView>(R.id.item_pacote_dias)
        dias.text = pacote.dias.formataDias()
    }

    private fun setupImage(viewCriada: View, pacote: Pacote) {
        val imagem = viewCriada.findViewById<ImageView>(R.id.item_pacote_image)
        val imagemPacote = returnDrawable(pacote)
        imagem.setImageDrawable(imagemPacote)
    }

    private fun returnDrawable(pacote: Pacote): Drawable {
        val resources = context.resources
        val idDoDrawable = resources.getIdentifier(pacote.imagem, "drawable", context.packageName)
        return resources.getDrawable(idDoDrawable)
    }

    private fun setupLocal(viewCriada: View, pacote: Pacote) {
        val local = viewCriada.findViewById<TextView>(R.id.item_pacote_local)
        local.text = pacote.local
    }

    override fun getItem(position: Int): Pacote {
        return listaPacotes[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount() = listaPacotes.size

}

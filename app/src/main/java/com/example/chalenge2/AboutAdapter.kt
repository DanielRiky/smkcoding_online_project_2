package com.example.chalenge2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.fitur_item.*


class AboutAdapter( private val context : Context, private val items : ArrayList<Fitur>) : RecyclerView.Adapter<AboutAdapter.ViewHolder> () {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from( context ).inflate(R.layout.fitur_item, parent, false )
    )
    override fun getItemCount(): Int {
        return items.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items.get(position))
    }
    class ViewHolder( override val containerView:View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bindItem(item:Fitur) {
            txtNama.text = item.nama
            txtFitur.text = item.fungsi
        }
    }
}
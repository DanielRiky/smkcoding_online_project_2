package com.example.chalenge2

import Attributess


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.corona_provinsi_item.*
import provinsiItem

class CoronaProvinsiAdapter(private val context : Context, private val items :
List<provinsiItem>, private val listener : (provinsiItem)-> Unit) :
    RecyclerView.Adapter<CoronaProvinsiAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder( context , LayoutInflater.from( context ).inflate(R.layout.corona_provinsi_item ,
            parent, false ))
    override fun getItemCount(): Int {
        return items . size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem( items .get(position), listener )
    }
    class ViewHolder( val context : Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: provinsiItem, listener: (provinsiItem) -> Unit) {
            nama_prov.text = item.attributess.provinsi
            jmlh_pos.text = item.attributess.kasusPosi.toString()
            jmlh_semb.text = item.attributess.kasusSemb.toString()
            jmlh_meni.text = item.attributess.kasusMeni.toString()

            containerView .setOnClickListener { listener(item) }
        }
    }
}
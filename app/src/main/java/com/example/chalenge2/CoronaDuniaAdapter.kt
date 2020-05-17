package com.example.chalenge2

import Attributess


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coronaNegaraItem
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.corona_dunia_item.*
import kotlinx.android.synthetic.main.corona_provinsi_item.*
import provinsiItem

class CoronaDuniaAdapter(private val context : Context, private val items :
List<coronaNegaraItem>, private val listener : (coronaNegaraItem)-> Unit) :
    RecyclerView.Adapter<CoronaDuniaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder( context , LayoutInflater.from( context ).inflate(R.layout.corona_dunia_item ,
            parent, false ))
    override fun getItemCount(): Int {
        return items . size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem( items .get(position), listener )
    }
    class ViewHolder( val context : Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: coronaNegaraItem, listener: (coronaNegaraItem) -> Unit) {
            nama_negara.text = item.attributesss.countryRegion
            jmlh_positif.text = item.attributesss.confirmed.toString()
            jmlh_sembun.text = item.attributesss.recovered.toString()
            jmlh_meninggal.text = item.attributesss.deaths.toString()

            containerView .setOnClickListener { listener(item) }
        }
    }
}
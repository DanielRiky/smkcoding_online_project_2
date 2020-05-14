package com.example.chalenge2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.corona_indonesia_item.*

class CoronaIndonesiaAdapter(private val context: Context, private val items:
List<Any>, private val listener: (CoronaIndonesiaItem)-> Unit) :
    RecyclerView.Adapter<CoronaIndonesiaAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder( context , LayoutInflater.from( context ).inflate(R.layout.corona_indonesia_item ,
            parent, false ))
    override fun getItemCount(): Int {
        return items . size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items .get(position) as CoronaIndonesiaItem, listener )
    }
    class ViewHolder( val context : Context, override val containerView : View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer{
        fun bindItem(item: CoronaIndonesiaItem,listener: (CoronaIndonesiaItem) -> Unit) {
            provinsi.text = item.name
            txtpositif.text = item.positif
            txtsembuh.text = item.sembuh
            txtmeninggal.text = item.meninggal

            containerView .setOnClickListener { listener(item) }
        }
    }
}
package com.example.mobile.pruebabold.view.weather

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile.pruebabold.R
import com.example.mobile.pruebabold.models.models_search.QueryModels

class SearchRecyclerViewAdapter  (
    val context : Context?,
    private var mValues: MutableList<QueryModels>
) : RecyclerView.Adapter<SearchRecyclerViewAdapter.ViewHolder>() {

    private var listener: ((QueryModels)-> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_list_location, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item: QueryModels = mValues[position]

        holder.tv_title.text         = item.title
        holder.tv_location_type.text = item.location_type
        holder.tv_latt_long.text     = item.latt_long
        holder.tv_woeid.text         = item.woeid.toString()

        setListeners(holder,item)
    }

    private fun setListeners(holder : ViewHolder, item : QueryModels){
        holder.mView
            .setOnClickListener {
                listener?.invoke(item)
            }
    }

    override fun getItemCount(): Int = mValues.size

    fun setData(listSearch : MutableList<QueryModels>){
        this.mValues = listSearch
        notifyDataSetChanged()
    }

    fun onClickListener(listener : (QueryModels)-> Unit){
        this.listener = listener
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

//        val tv_icon         : TextView = mView.findViewById(R.id.ivc_avatar)
        val tv_title         : TextView = mView.findViewById(R.id.tv_title_location)
        val tv_location_type : TextView = mView.findViewById(R.id.tv_type_location)
        val tv_latt_long     : TextView = mView.findViewById(R.id.tv_latt_long)
        val tv_woeid         : TextView = mView.findViewById(R.id.tv_woeid)

    }
}
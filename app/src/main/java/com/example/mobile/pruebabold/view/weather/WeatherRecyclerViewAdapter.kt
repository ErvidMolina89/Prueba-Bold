package com.example.mobile.pruebabold.view.weather

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.example.mobile.pruebabold.R
import com.example.mobile.pruebabold.models.models_search.QueryModels

class WeatherRecyclerViewAdapter  (
    private var mValues: MutableList<QueryModels>
) : RecyclerView.Adapter<WeatherRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    private val searchListViewModel : WeatherViewModel

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as QueryModels
        }

        searchListViewModel = ViewModelProviders.of(context as FragmentActivity).get(
            WeatherViewModel::class.java)
    }

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

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    private fun setListeners(holder : ViewHolder, item : QueryModels){
        holder.mView
            .setOnClickListener {
                it
            }
    }

    override fun getItemCount(): Int = mValues.size

    fun setData(listSearch : MutableList<QueryModels>){
        this.mValues = listSearch
        notifyDataSetChanged()
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {

        val tv_title         : TextView = mView.findViewById(R.id.tv_title_location)
        val tv_location_type : TextView = mView.findViewById(R.id.tv_type_location)
        val tv_latt_long     : TextView = mView.findViewById(R.id.tv_latt_long)
        val tv_woeid         : TextView = mView.findViewById(R.id.tv_woeid)

    }
}
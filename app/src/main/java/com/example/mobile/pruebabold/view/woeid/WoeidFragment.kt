package com.example.mobile.pruebabold.view.woeid

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.databinding.FragmentWoeidBinding
import com.example.mobile.pruebabold.models.models_search.QueryModels
import com.example.mobile.pruebabold.models.models_woeid.ConsolidatedWeatherModels
import com.example.mobile.pruebabold.models.models_woeid.WoeidModels
import com.example.mobile.pruebabold.utlis.showInlog
import com.example.mobile.pruebabold.view.weather.SearchViewModelDelegate
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import javax.inject.Inject


class WoeidFragment : Fragment() {

    @Inject
    lateinit var woeidViewModel: WoeidViewModel
    lateinit var binding: FragmentWoeidBinding
    private var queryModel: QueryModels? = null
    private var lineDataSet: LineDataSet? = null
    private var lineDataSet2: LineDataSet? = null
    private var lineDataSet3: LineDataSet? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        (App.getContext() as App).getComponentApplication()?.inject(this)
        binding = FragmentWoeidBinding.inflate(inflater)
        woeidViewModel.setDelegate(ResponseViewModel())
        woeidViewModel.callInfoWoeid(queryModel!!.woeid!!)
        setInfoHeader()
        return binding.root
    }

    private fun setInfoHeader(){
        binding.tvTitleDetails.text = queryModel!!.title
        binding.tvLocationTypeDetails.text = queryModel!!.location_type
        binding.tvWoeidDetails.text = queryModel!!.woeid.toString()
    }

    private fun configGraphic(listWoeid: MutableList<ConsolidatedWeatherModels>){
        binding.lineChart.visibility = View.VISIBLE
        val list_temPromedio = emptyList<Entry>().toMutableList()
        val list_temMin = emptyList<Entry>().toMutableList()
        val list_temMax = emptyList<Entry>().toMutableList()

        for (item in listWoeid){
            list_temPromedio.add(Entry(list_temPromedio.size.toFloat(), item.the_temp!!))
            list_temMin.add(Entry(list_temMin.size.toFloat(), item.min_temp!!))
            list_temMax.add(Entry(list_temMax.size.toFloat(), item.max_temp!!))
        }

        lineDataSet = LineDataSet(list_temPromedio, "Temperatura Promedio")
        lineDataSet?.setCircleColor(Color.RED)
        lineDataSet?.setColor(Color.RED)

        lineDataSet2 = LineDataSet(list_temMin, "Temperatura Minima")

        lineDataSet3 = LineDataSet(list_temMax, "Temperatura Maxima")
        lineDataSet3?.setColor(Color.GREEN)

        // Asociamos al gráfico
        val lineData = LineData()
        lineData.addDataSet(lineDataSet)
        lineData.addDataSet(lineDataSet2)
        lineData.addDataSet(lineDataSet3)
        binding.lineChart.setData(lineData)
    }

    fun setQueryModels(queryModel: QueryModels){
        this.queryModel = queryModel
    }

    inner class ResponseViewModel : WoeidViewModelDelegate {
        override fun setMediaQuery(woeidModels: WoeidModels) {
            configGraphic(woeidModels.consolidated_weather!!)
        }

        override fun setFailDataLoad() {
            "Fallo".showInlog("Respuesta Fallida")
        }
    }
}
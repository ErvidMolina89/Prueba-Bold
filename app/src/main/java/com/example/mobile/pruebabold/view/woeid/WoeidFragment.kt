package com.example.mobile.pruebabold.view.woeid

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableRow
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.mobile.pruebabold.R
import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.databinding.FragmentWoeidBinding
import com.example.mobile.pruebabold.models.models_search.QueryModels
import com.example.mobile.pruebabold.models.models_woeid.ConsolidatedWeatherModels
import com.example.mobile.pruebabold.models.models_woeid.WoeidModels
import com.example.mobile.pruebabold.utlis.*
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
    private var listWoeid: MutableList<ConsolidatedWeatherModels>? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        (App.getContext() as App).getComponentApplication()?.inject(this)
        binding = FragmentWoeidBinding.inflate(inflater)
        woeidViewModel.setDelegate(ResponseViewModel())

        if(context?.isNetworkAvailable()!!) {
            woeidViewModel.callInfoWoeid(queryModel!!.woeid!!)
            context?.showProgress()
        } else {
            DialogGeneric
                .getInstance()
                .withTitle(R.string.internet)
                .withText(getString(R.string.no_internet))
                .withTextBtnOk(R.string.btn_accept)
                .withActionBtnOk {

                }
            context?.showDialogGeneric()
        }

        setInfoHeader()
        return binding.root
    }

    private fun setInfoHeader(){
        binding.tvTitleDetails.text = queryModel!!.title
        binding.tvLocationTypeDetails.text = queryModel!!.location_type
        binding.tvWoeidDetails.text = queryModel!!.woeid.toString()

    }

    private fun configGraphic(){
        binding.lineChart.visibility = View.VISIBLE
        val list_temPromedio = emptyList<Entry>().toMutableList()
        val list_predictability = emptyList<Entry>().toMutableList()
        val list_humidity = emptyList<Entry>().toMutableList()

        for (item in listWoeid!!){
            list_temPromedio.add(Entry(list_temPromedio.size.toFloat(), item.the_temp!!))
            list_predictability.add(Entry(list_predictability.size.toFloat(), item.predictability!!.toFloat()))
            list_humidity.add(Entry(list_humidity.size.toFloat(), item.humidity!!.toFloat()))
        }

        lineDataSet = LineDataSet(list_temPromedio, "Temp Promedio")

        lineDataSet2 = LineDataSet(list_predictability, "Predictability")
        lineDataSet?.setCircleColor(Color.RED)
        lineDataSet?.setColor(Color.RED)

        lineDataSet3 = LineDataSet(list_humidity, "Humedad")
        lineDataSet3?.setCircleColor(Color.RED)
        lineDataSet3?.setColor(Color.GREEN)

        // Asociamos al gr??fico
        val lineData = LineData()
        lineData.addDataSet(lineDataSet)
        lineData.addDataSet(lineDataSet2)
        lineData.addDataSet(lineDataSet3)
        lineData.addDataSet(lineDataSet3)
        binding.lineChart.setData(lineData)
    }

    private fun configTable(){
        var row: TableRow? = null
        configTableHeader()

        for (item in listWoeid!!){
            row = TableRow(activity)

            val lp = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
            row.setLayoutParams(lp)
            row.setBackgroundResource(R.drawable.border_table)

            val date = TextView(activity)
            date.text = item.applicable_date
            date.textAlignment = View.TEXT_ALIGNMENT_CENTER
            date.setTextColor(Color.BLACK)
            row.addView(date)

            val temp = TextView(activity)
            temp.text = item.the_temp.toString()
            temp.textAlignment = View.TEXT_ALIGNMENT_CENTER
            row.addView(temp)

            val state = TextView(activity)
            state.text = item.weather_state_name
            state.textAlignment = View.TEXT_ALIGNMENT_CENTER
            row.addView(state)

            val humidity = TextView(activity)
            humidity.text = item.humidity.toString()
            humidity.textAlignment = View.TEXT_ALIGNMENT_CENTER
            row.addView(humidity)

            binding.tlDataWeather.addView(row)
        }
    }

    private fun configTableHeader(){
        var row: TableRow? = null
        row = TableRow(activity)

        val lp = TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT)
        row.setLayoutParams(lp)
        row.setBackgroundResource(R.drawable.border_table)

        val date_name = TextView(activity)
        date_name.text = getString(R.string.date)
        date_name.textAlignment = View.TEXT_ALIGNMENT_CENTER
        date_name.setTextColor(Color.BLUE)
        row.addView(date_name)

        val temp_name = TextView(activity)
        temp_name.text = getString(R.string.temp)
        temp_name.textAlignment = View.TEXT_ALIGNMENT_CENTER
        temp_name.setTextColor(Color.BLUE)
        row.addView(temp_name)

        val state_name = TextView(activity)
        state_name.text = getString(R.string.state_weather)
        state_name.textAlignment = View.TEXT_ALIGNMENT_CENTER
        state_name.setTextColor(Color.BLUE)
        row.addView(state_name)

        val humidity = TextView(activity)
        humidity.text = getString(R.string.humidity)
        humidity.textAlignment = View.TEXT_ALIGNMENT_CENTER
        humidity.setTextColor(Color.BLUE)
        row.addView(humidity)

        binding.tlDataWeather.addView(row, 0)
    }

    fun setQueryModels(queryModel: QueryModels){
        this.queryModel = queryModel
    }

    inner class ResponseViewModel : WoeidViewModelDelegate {
        override fun setMediaQuery(woeidModels: WoeidModels) {
            listWoeid = woeidModels.consolidated_weather
            context?.hiddenProgress()
            configGraphic()
            configTable()
        }

        override fun setFailDataLoad() {
            "Fallo".showInlog("Respuesta Fallida")
        }

        override fun notifyListEmpty() {
            DialogGeneric
                .getInstance()
                .withTitle(R.string.list_is_empty)
                .withText("No se encontraron datos")
                .withTextBtnOk(R.string.btn_accept)
                .withActionBtnOk {

                }
            context?.hiddenProgress()
        }
    }
}
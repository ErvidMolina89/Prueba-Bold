package com.example.mobile.pruebabold.view.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobile.pruebabold.R
import com.example.mobile.pruebabold.base.App
import javax.inject.Inject

class WeatherFragment : Fragment() {

    @Inject
    lateinit var searchViewModel: WeatherViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        (App.getContext() as App).getComponentApplication()?.inject(this)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        searchViewModel.callInfoSearch("san")

        return root
    }

}
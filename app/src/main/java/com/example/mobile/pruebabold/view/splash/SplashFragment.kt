package com.example.mobile.pruebabold.view.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mobile.pruebabold.R
import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.databinding.FragmentSearchBinding
import com.example.mobile.pruebabold.databinding.FragmentSplashBinding
import com.example.mobile.pruebabold.models.models_search.QueryModels
import com.example.mobile.pruebabold.view.weather.SearchFragment
import javax.inject.Inject

class SplashFragment : Fragment() {

    private var delegate: SplashFragmentDelegate? = null
    lateinit var binding: FragmentSplashBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSplashBinding.inflate(inflater)
        delegate?.navigationFragmentSearch()
        return binding.root
    }

    fun setDelegate(delegate: SplashFragmentDelegate){
        this.delegate = delegate
    }

    interface SplashFragmentDelegate {
        fun navigationFragmentSearch()
    }
}
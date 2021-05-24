package com.example.mobile.pruebabold

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.models.models_search.QueryModels
import com.example.mobile.pruebabold.view.weather.SearchFragment
import com.example.mobile.pruebabold.view.weather.SearchViewModel
import com.example.mobile.pruebabold.view.woeid.WoeidFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentSearch: SearchFragment
    @Inject
    lateinit var fragmentWoeid: WoeidFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        (App.getContext() as App).getComponentApplication()?.inject(this)
        fragmentSearch.setDelegate(responseFragmentSearch())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigationFragment(fragmentSearch)
    }

    private fun navigationFragment(fragment: Fragment, tag: String? = null){
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).addToBackStack(tag).commit()
    }

    inner class responseFragmentSearch : SearchFragment.SearchFragmentDelegate {
        override fun showDetailsItemSelect(location: QueryModels) {
            fragmentWoeid.setQueryModels(location)
            navigationFragment(fragmentWoeid, "fragmentWoeid")

        }

    }
}
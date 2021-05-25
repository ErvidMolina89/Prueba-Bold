package com.example.mobile.pruebabold

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import android.os.Looper
import android.view.inputmethod.InputMethodManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.models.models_search.QueryModels
import com.example.mobile.pruebabold.view.splash.SplashFragment
import com.example.mobile.pruebabold.view.weather.SearchFragment
import com.example.mobile.pruebabold.view.weather.SearchViewModel
import com.example.mobile.pruebabold.view.woeid.WoeidFragment
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentSearch: SearchFragment
    @Inject
    lateinit var fragmentWoeid: WoeidFragment
    @Inject
    lateinit var fragmentSplash: SplashFragment

    lateinit var fragment: Fragment
    private var landscape: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        (App.getContext() as App).getComponentApplication()?.inject(this)

        fragmentSearch.setDelegate(responseFragmentSearch())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationFragment(fragmentSplash)
        Thread{
            Thread.sleep(2000)
            runOnUiThread{
                navigationFragment(fragmentSearch, getString(R.string.key_fragment_search))
            }
        }.start()

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if(newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE){
            landscape = true
            reloadFragment(fragment)
        }
        if(newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            landscape = false
            reloadFragment(fragment)
        }
    }

    private fun navigationFragment(fragment: Fragment, tag: String? = null){
        this.fragment = fragment
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, fragment).addToBackStack(tag).commit()
    }

    private fun reloadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().show(fragment).commit()
    }

    inner class responseFragmentSearch : SearchFragment.SearchFragmentDelegate {
        override fun showDetailsItemSelect(location: QueryModels) {
            fragmentWoeid.setQueryModels(location)
            navigationFragment(fragmentWoeid, getString(R.string.key_fragment_woeid))

        }

    }
}
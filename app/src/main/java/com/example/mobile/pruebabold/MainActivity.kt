package com.example.mobile.pruebabold

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.models.models_search.QueryModels
import com.example.mobile.pruebabold.view.splash.SplashFragment
import com.example.mobile.pruebabold.view.weather.SearchFragment
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
        fragmentSplash.setDelegate(responseFragmentSplash())

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationFragment(fragmentSplash)

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

    inner class responseFragmentSplash : SplashFragment.SplashFragmentDelegate{
        override fun navigationFragmentSearch() {Thread{
            Thread.sleep(3000)
            runOnUiThread{
                navigationFragment(fragmentSearch, getString(R.string.key_fragment_search))
            }
        }.start()
        }
    }
}
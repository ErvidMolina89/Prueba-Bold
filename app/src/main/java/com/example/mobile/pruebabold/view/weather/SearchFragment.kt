package com.example.mobile.pruebabold.view.weather

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.databinding.FragmentSearchBinding
import com.example.mobile.pruebabold.models.models_search.QueryModels
import com.example.mobile.pruebabold.utlis.showInlog
import javax.inject.Inject

class SearchFragment : Fragment() {

    @Inject
    lateinit var searchViewModel: SearchViewModel
    lateinit var binding: FragmentSearchBinding
    private var adapter: SearchRecyclerViewAdapter = SearchRecyclerViewAdapter(context, emptyList<QueryModels>().toMutableList())
    private var delegate: SearchFragmentDelegate? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        (App.getContext() as App).getComponentApplication()?.inject(this)
        binding = FragmentSearchBinding.inflate(inflater)

        searchViewModel.setDelegate(ResponseViewModel())
        onStyleRecycler()
        listenerRevycler()
        listenerEditTextSearch()

        return binding.root
    }

    private fun listenerEditTextSearch(){
        binding.editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                searchViewModel.callInfoSearch(p0.toString())
            }

        })
    }

    private fun listenerRevycler(){
        adapter.onClickListener {
            searchViewModel.showDetailsItemSelect(it)
        }
    }

    private fun onStyleRecycler() {
        binding.recyclerViewSearchResults.let{
            it.layoutManager = LinearLayoutManager(context)
            it.adapter = adapter
            it.setHasFixedSize(true)
        }
    }

    fun setDelegate(delegate: SearchFragmentDelegate){
        this.delegate = delegate
    }

    inner class ResponseViewModel : SearchViewModelDelegate {
        override fun setMediaQuery(list: MutableList<QueryModels>) {
            adapter.setData(list)
        }

        override fun setFailDataLoad() {
            "Fallo".showInlog("Respuesta Fallida")
        }

        override fun navigationToLocation(location: QueryModels) {
            delegate?.showDetailsItemSelect(location)
            val imm: InputMethodManager? = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
            imm?.hideSoftInputFromWindow(binding.editTextSearch.getWindowToken(), 0)
        }
    }

    interface SearchFragmentDelegate {
        fun showDetailsItemSelect(location: QueryModels)
    }

}
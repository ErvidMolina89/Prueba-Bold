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
import com.example.mobile.pruebabold.R
import com.example.mobile.pruebabold.base.App
import com.example.mobile.pruebabold.databinding.FragmentSearchBinding
import com.example.mobile.pruebabold.models.models_search.QueryModels
import com.example.mobile.pruebabold.utlis.*
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
        context?.hiddenProgress()

        return binding.root
    }

    private fun listenerEditTextSearch(){
        binding.editTextSearch.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(context?.isNetworkAvailable()!!) {
                    searchViewModel.callInfoSearch(p0.toString())
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

    private fun hideKeyboard(){
        val imm: InputMethodManager? = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(binding.editTextSearch.getWindowToken(), 0)
    }

    inner class ResponseViewModel : SearchViewModelDelegate {
        override fun setMediaQuery(list: MutableList<QueryModels>) {
            binding.includeListEmpty.visibility = View.GONE
            adapter.setData(list)
            context?.hiddenProgress()
            hideKeyboard()
        }

        override fun setFailDataLoad() {
            "Fallo".showInlog("Respuesta Fallida")
        }

        override fun navigationToLocation(location: QueryModels) {
            delegate?.showDetailsItemSelect(location)
            hideKeyboard()
        }

        override fun notifyListEmpty() {
            binding.includeListEmpty.visibility = View.VISIBLE
            adapter.setData(emptyList<QueryModels>().toMutableList())
            context?.hiddenProgress()
            hideKeyboard()
        }
    }

    interface SearchFragmentDelegate {
        fun showDetailsItemSelect(location: QueryModels)
    }

}
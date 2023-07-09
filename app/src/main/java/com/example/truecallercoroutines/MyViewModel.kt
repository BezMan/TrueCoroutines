package com.example.truecallercoroutines

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MyViewModel : ViewModel() {

    private val dispatcher: CoroutineDispatcher = Dispatchers.IO

    private val _viewState = MutableLiveData<String>()
    val viewState: LiveData<String>
        get() = _viewState


    fun fetchHtml(endPointUrl: String) {
        viewModelScope.launch(dispatcher) {
            val html = NetworkUtils.fetchHtml(endPointUrl)
            _viewState.postValue(html)
        }

    }

}
package com.example.phoneandtablet.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phoneandtablet.data.model.simpson.RelatedTopicModel
import com.example.phoneandtablet.data.model.simpson.SimpsonDataModel
import com.example.phoneandtablet.data.remote.simpson.SimpsonDetails
import com.example.phoneandtablet.data.repository.Repository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: Repository
): ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _details = MutableLiveData<SimpsonDataModel>()
    val details : LiveData<SimpsonDataModel> = _details

    fun getSimpson(query: String, format: String) {
        viewModelScope.launch {
            try {
                val result = repository.getSimpson("simpsons+characters", "json")

                // Log the result
                Log.d("HomeViewModel", "Fetched Data: $result")

                _details.postValue(result?:SimpsonDataModel())
            } catch (e: Exception) {
                // Log any errors
                Log.e("HomeViewModel", "Error fetching data: ${e.message}")
            }

        }
    }
}
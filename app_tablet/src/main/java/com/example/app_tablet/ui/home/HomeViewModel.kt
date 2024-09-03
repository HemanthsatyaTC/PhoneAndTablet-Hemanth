package com.example.app_tablet.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_tablet.data.model.simpson.RelatedTopicModel
import com.example.app_tablet.data.model.wire.RelatedTopicModelWire
import com.example.app_tablet.data.remote.simpson.SimpsonDetails
import com.example.app_tablet.data.remote.wire.WireDetails
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _detailsleft = MutableLiveData<RelatedTopicModel>()
    val detailsleft : LiveData<RelatedTopicModel> = _detailsleft

    fun getSimpson(query: String, format: String) {
        viewModelScope.launch {
            try {
                val result = SimpsonDetails.retrofitDetails.getSimpson("simpsons+characters", "json")

                // Log the result
                Log.d("HomeViewModel", "Fetched Data: $result")

                _detailsleft.postValue(result)
            } catch (e: Exception) {
                // Log any errors
                Log.e("HomeViewModel", "Error fetching data: ${e.message}")
            }

        }
    }
    private val _detailsRight = MutableLiveData<RelatedTopicModelWire>()
    val detailsRight : LiveData<RelatedTopicModelWire> = _detailsRight

    fun getWire(query: String ="the+wire+characters", format: String ="json") {
        viewModelScope.launch {
            try {
                val result = WireDetails.retrofitDetails.getWire("simpsons+characters", "json")

                // Log the result
                Log.d("DashBoardViewModel", "Fetched Data: $result")

                _detailsRight.postValue(result)
            } catch (e: Exception) {
                // Log any errors
                Log.e("DashBoardViewModel", "Error fetching data: ${e.message}")
            }

        }
    }
}
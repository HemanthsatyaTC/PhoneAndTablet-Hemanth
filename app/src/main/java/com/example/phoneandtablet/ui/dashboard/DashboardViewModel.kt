package com.example.phoneandtablet.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phoneandtablet.data.model.simpson.RelatedTopicModel
import com.example.phoneandtablet.data.model.wire.RelatedTopicModelWire
import com.example.phoneandtablet.data.remote.simpson.SimpsonDetails
import com.example.phoneandtablet.data.remote.wire.WireDetails
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private val _details = MutableLiveData<RelatedTopicModelWire>()
    val details : LiveData<RelatedTopicModelWire> = _details

    fun getWire(query: String ="the+wire+characters", format: String ="json") {
        viewModelScope.launch {
            try {
                val result = WireDetails.retrofitDetails.getWire("simpsons+characters", "json")

                // Log the result
                Log.d("DashBoardViewModel", "Fetched Data: $result")

                _details.postValue(result)
            } catch (e: Exception) {
                // Log any errors
                Log.e("DashBoardViewModel", "Error fetching data: ${e.message}")
            }

        }
    }
}
package com.example.phoneandtablet.ui.dashboard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.phoneandtablet.data.model.simpson.RelatedTopicModel
import com.example.phoneandtablet.data.model.wire.RelatedTopicModelWire
import com.example.phoneandtablet.data.model.wire.WireDataModel
import com.example.phoneandtablet.data.remote.simpson.SimpsonDetails
import com.example.phoneandtablet.data.remote.wire.WireDetails
import com.example.phoneandtablet.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    private val _details = MutableLiveData<WireDataModel>()
    val details : LiveData<WireDataModel> = _details

    fun getWire(query: String ="the+wire+characters", format: String ="json") {
        viewModelScope.launch {
            try {
                val result = repository.getWire("the+wire+characters", "json")

                // Log the result
                Log.d("DashBoardViewModel", "Fetched Data: $result")

                _details.postValue(result?:WireDataModel())
            } catch (e: Exception) {
                // Log any errors
                Log.e("DashBoardViewModel", "Error fetching data: ${e.message}")
            }

        }
    }
}
package com.example.app_tablet.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_tablet.data.model.simpson.RelatedTopicModel
import com.example.app_tablet.data.model.simpson.SimpsonDataModel
import com.example.app_tablet.data.model.wire.RelatedTopicModelWire
import com.example.app_tablet.data.model.wire.WireDataModel
import com.example.app_tablet.data.remote.simpson.SimpsonDetails
import com.example.app_tablet.data.remote.wire.WireDetails
import com.example.app_tablet.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _detailsleft = MutableLiveData<SimpsonDataModel>()
    val detailsleft : LiveData<SimpsonDataModel> = _detailsleft

    fun getSimpson(query: String, format: String) {
        viewModelScope.launch {
            try {
                val result = repository.getSimpson("simpsons+characters", "json")

                // Log the result
                Log.d("HomeViewModel", "Fetched Data: $result")

                _detailsleft.postValue(result?:SimpsonDataModel())
            } catch (e: Exception) {
                // Log any errors
                Log.e("HomeViewModel", "Error fetching data: ${e.message}")
            }

        }
    }
    private val _detailsRight = MutableLiveData<WireDataModel>()
    val detailsRight : LiveData<WireDataModel> = _detailsRight

    fun getWire(query: String ="the+wire+characters", format: String ="json") {
        viewModelScope.launch {
            try {
                val result = repository.getWire("the+wire+characters", "json")

                // Log the result
                Log.d("DashBoardViewModel", "Fetched Data: $result")

                _detailsRight.postValue(result?:WireDataModel())
            } catch (e: Exception) {
                // Log any errors
                Log.e("DashBoardViewModel", "Error fetching data: ${e.message}")
            }

        }
    }
}
package com.example.eurogas.ui

import GasStation
import GasStationsResponse
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.eurogas.dependencies.EuroGas
import com.example.eurogas.repositories.GasStationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response

data class ListGasStationUiState(
    val loading: Boolean = false,
    val error: String = "",
    val gasStations: List<GasStation> = emptyList()
)

class GasStationVM(
    private val gasStationRepository: GasStationRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<ListGasStationUiState> = MutableStateFlow(
        ListGasStationUiState()
    )
    val uiState: StateFlow<ListGasStationUiState> = _uiState.asStateFlow()

    private var allGasStations: List<GasStation> = emptyList()

    init {
        fetchGasStations()
    }

    fun fetchGasStations() {
        viewModelScope.launch {
            _uiState.value = ListGasStationUiState(loading = true)
            val response = gasStationRepository.getGasStations()
            if (response.isSuccessful) {
                val gasStationsResponse = response.body()
                allGasStations = gasStationsResponse?.gasStations ?: emptyList()
                _uiState.value =
                    ListGasStationUiState(loading = false, gasStations = allGasStations)
            } else {
                Log.e("GasStationVM", "Error fetching gas stations: ${response.errorBody()}")
                _uiState.value =
                    ListGasStationUiState(loading = false, error = response.errorBody().toString())
            }
        }
    }

    fun filterGasStationsByName(name: String) {
        val filteredGasStations =
            allGasStations.filter { it.locality.contains(name, ignoreCase = true) }
        _uiState.value = _uiState.value.copy(gasStations = filteredGasStations)
    }


    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application =
                    checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                return GasStationVM(
                    (application as EuroGas).appContainer.GasStationRepository
                ) as T
            }
        }
    }
}
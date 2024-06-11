package com.example.eurogas.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.eurogas.R
import com.example.eurogas.databinding.FragmentGasStationListBinding


class GasStationList : Fragment() {

    private var _binding: FragmentGasStationListBinding? = null
    private val binding
        get() = _binding!!

    private val gasStationVM by viewModels<GasStationVM> { GasStationVM.Factory }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentGasStationListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        lifecycleScope.launchWhenStarted {
            gasStationVM.uiState.collect { uiState ->
                // Show or hide the loading indicator
                binding.progressBar.visibility = if (uiState.loading) View.VISIBLE else View.GONE

                // Update the adapter when the data changes
                if (uiState.gasStations != null) {
                    Log.d(
                        "GasStationList",
                        "Updating adapter with new data: ${uiState.gasStations}"
                    )
                    (binding.rvGasStation.adapter as GasStationAdapter).updateGasStations(uiState.gasStations)
                }
            }
        }

        // Set up the SearchView
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                gasStationVM.filterGasStationsByName(newText ?: "")
                return true
            }
        })
    }

    private fun initRecyclerView() {
        binding.rvGasStation.layoutManager = LinearLayoutManager(requireContext())
        binding.rvGasStation.adapter = GasStationAdapter(listOf())
    }


}
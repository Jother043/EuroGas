package com.example.eurogas.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import GasStation
import android.util.Log
import com.example.eurogas.databinding.GasstationItemBinding

class GasStationAdapter(private var gasStations: List<GasStation>) :
    RecyclerView.Adapter<GasStationAdapter.GasStationViewHolder>() {

    class GasStationViewHolder(private val binding: GasstationItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(gasStation: GasStation) {
            binding.tvName.text = gasStation.municipality
            binding.tvCal.text = gasStation.dieselAPrice
            binding.tvEco.text = gasStation.gasoline95E5Price
            binding.tvNameGas.text = gasStation.label
            // Set other fields as needed
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GasStationViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = GasstationItemBinding.inflate(layoutInflater, parent, false)
        return GasStationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GasStationViewHolder, position: Int) {
        holder.bind(gasStations[position])
    }

    override fun getItemCount(): Int {
        return gasStations.size
    }

    fun updateGasStations(newGasStations: List<GasStation>) {
        gasStations = newGasStations
        Log.d("GasStationAdapter", "Updating UI with new data: $newGasStations")
        notifyDataSetChanged()
    }

}
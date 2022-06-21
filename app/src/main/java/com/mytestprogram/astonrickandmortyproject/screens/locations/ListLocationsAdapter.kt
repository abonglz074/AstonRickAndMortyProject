package com.mytestprogram.astonrickandmortyproject.screens.locations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse.SingleLocation
import com.mytestprogram.astonrickandmortyproject.databinding.LocationsRecyclerviewItemBinding

class ListLocationsAdapter:
    RecyclerView.Adapter<ListLocationsAdapter.ListLocationsViewHolder>() {

    var locations: List<SingleLocation> = emptyList()

        set(newValue){
            field = newValue
            notifyDataSetChanged()
        }



//
//    private val diffCallback = object : DiffUtil.ItemCallback<GetCharacterByIdResponse>() {
//
//        override fun areItemsTheSame(oldItem: GetCharacterByIdResponse, newItem: GetCharacterByIdResponse): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: GetCharacterByIdResponse, newItem: GetCharacterByIdResponse): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    private val differ = AsyncListDiffer(this, diffCallback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListLocationsViewHolder {
        return ListLocationsViewHolder(
            LocationsRecyclerviewItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: ListLocationsViewHolder, position: Int) {
        val singleLocation = locations[position]
        with(holder.binding) {
            locationName.text = singleLocation.name
            locationsType.text = singleLocation.type
            locationDimension.text = singleLocation.dimension
        }
    }

    override fun getItemCount(): Int = locations.size


    class ListLocationsViewHolder(var binding: LocationsRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
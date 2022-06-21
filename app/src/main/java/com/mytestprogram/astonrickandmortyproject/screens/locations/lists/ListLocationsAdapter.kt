package com.mytestprogram.astonrickandmortyproject.screens.locations.lists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse.SingleLocation
import com.mytestprogram.astonrickandmortyproject.databinding.LocationsRecyclerviewItemBinding
import com.mytestprogram.astonrickandmortyproject.screens.characters.lists.ListCharactersActionListener

class ListLocationsAdapter(
    private val actionListener: ListLocationsActionListener
): RecyclerView.Adapter<ListLocationsAdapter.ListLocationsViewHolder>(), View.OnClickListener {

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
        val inflater = LayoutInflater.from(parent.context)
        val binding = LocationsRecyclerviewItemBinding.inflate(inflater, parent, false)

        binding.root.setOnClickListener(this)

        return ListLocationsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ListLocationsViewHolder, position: Int) {
        val singleLocation = locations[position]
        holder.itemView.tag = singleLocation
        with(holder.binding) {
            locationName.text = singleLocation.name
            locationsType.text = singleLocation.type
            locationDimension.text = singleLocation.dimension
        }
    }

    override fun onClick(v: View) {
        val singleLocation = v.tag as SingleLocation
        actionListener.onLocationDetailsScreen(singleLocation)
    }

    override fun getItemCount(): Int = locations.size


    class ListLocationsViewHolder(var binding: LocationsRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
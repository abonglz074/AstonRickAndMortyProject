package com.mytestprogram.astonrickandmortyproject.screens.episodes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.SingleEpisode
import com.mytestprogram.astonrickandmortyproject.databinding.CharacterDetailsRecyclerviewEpisodesItemBinding

class ListEpisodesAdapter: RecyclerView.Adapter<ListEpisodesAdapter.ListEpisodesViewHolder>() {

    var episodes: List<SingleEpisode> = emptyList()

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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListEpisodesViewHolder {
        return ListEpisodesViewHolder(
            CharacterDetailsRecyclerviewEpisodesItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: ListEpisodesViewHolder, position: Int) {
        val singleEpisode = episodes[position]
        with(holder.binding) {
            episodeName.text = singleEpisode.name
            episodeNumber.text = singleEpisode.episode
            episodeAirdate.text = singleEpisode.air_date
        }
    }

    override fun getItemCount(): Int = episodes.size


    class ListEpisodesViewHolder(var binding: CharacterDetailsRecyclerviewEpisodesItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
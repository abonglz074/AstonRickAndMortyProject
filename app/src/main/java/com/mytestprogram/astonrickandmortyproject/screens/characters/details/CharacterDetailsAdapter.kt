package com.mytestprogram.astonrickandmortyproject.screens.characters.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.SingleEpisode
import com.mytestprogram.astonrickandmortyproject.databinding.CharacterDetailsRecyclerviewEpisodesItemBinding
import com.mytestprogram.astonrickandmortyproject.screens.episodes.lists.ListEpisodesActionListener

class CharacterDetailsAdapter(
    private val actionListener: ListEpisodesActionListener
) :
    RecyclerView.Adapter<CharacterDetailsAdapter.CharacterDetailsViewHolder>(),
    View.OnClickListener {


    var episodes: List<SingleEpisode> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterDetailsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            CharacterDetailsRecyclerviewEpisodesItemBinding.inflate(inflater, parent, false)

        binding.root.setOnClickListener(this)
        return CharacterDetailsViewHolder(binding)
    }

    override fun onClick(v: View) {
        val singleEpisode = v.tag as SingleEpisode
        actionListener.showEpisodeDetailsScreen(singleEpisode)
    }

    override fun onBindViewHolder(holder: CharacterDetailsViewHolder, position: Int) {
        val singleEpisode = episodes[position]
        holder.itemView.tag = singleEpisode
        with(holder.binding) {
            episodeName.text = singleEpisode.name
            episodeNumber.text = singleEpisode.episode
            episodeAirdate.text = singleEpisode.air_date
        }
    }

    override fun getItemCount(): Int = episodes.size

    class CharacterDetailsViewHolder(val binding: CharacterDetailsRecyclerviewEpisodesItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
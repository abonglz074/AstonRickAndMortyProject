package com.mytestprogram.astonrickandmortyproject.screens.locations.details

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.SingleCharacter
import com.mytestprogram.astonrickandmortyproject.databinding.CharactersListRecyclerviewItemBinding
import com.mytestprogram.astonrickandmortyproject.screens.characters.lists.ListCharactersActionListener
import com.mytestprogram.astonrickandmortyproject.screens.episodes.details.EpisodeDetailsAdapter

class LocationDetailsAdapter(
    private val actionListener: ListCharactersActionListener
) :
    RecyclerView.Adapter<LocationDetailsAdapter.LocationDetailsViewHolder>(),
    View.OnClickListener {


    var characters: List<SingleCharacter> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationDetailsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding =
            CharactersListRecyclerviewItemBinding.inflate(inflater, parent, false)

        binding.root.setOnClickListener(this)
        return LocationDetailsViewHolder(binding)
    }

    override fun onClick(v: View) {
        val singleCharacter = v.tag as SingleCharacter
        val characterId = singleCharacter.id
        actionListener.onCharacterDetailsScreen(characterId)
    }

    override fun onBindViewHolder(holder: LocationDetailsViewHolder, position: Int) {
        val singleCharacter = characters[position]
        holder.itemView.tag = singleCharacter
        with(holder.binding) {
            characterNameTextView.text = singleCharacter.name
            characterSpeciesTextView.text = singleCharacter.species
            characterStatusTextView.text = singleCharacter.status
            characterGenderTextView.text = singleCharacter.gender
            Glide.with(holder.itemView)
                .load(singleCharacter.image)
                .into(characterImageView)
        }
    }

    override fun getItemCount(): Int = characters.size

    class LocationDetailsViewHolder(val binding: CharactersListRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
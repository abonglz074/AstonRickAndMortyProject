package com.mytestprogram.astonrickandmortyproject.screens.characters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.SingleCharacter
import com.mytestprogram.astonrickandmortyproject.databinding.CharactersListRecyclerviewItemBinding

class ListCharactersAdapter:
    RecyclerView.Adapter<ListCharactersAdapter.ListCharactersViewHolder>() {

    var characters: List<SingleCharacter> = emptyList()

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


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCharactersViewHolder {
        return ListCharactersViewHolder(
            CharactersListRecyclerviewItemBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder: ListCharactersViewHolder, position: Int) {
        val singleCharacter = characters[position]
        Glide.with(holder.itemView)
            .load(singleCharacter.image)
            .into(holder.binding.characterImageView)
        with(holder.binding) {
            characterNameTextView.text = singleCharacter.name
            characterGenderTextView.text = singleCharacter.gender
            characterSpeciesTextView.text = singleCharacter.species
            characterStatusTextView.text = singleCharacter.status
        }
    }

    override fun getItemCount(): Int = characters.size


    class ListCharactersViewHolder(var binding: CharactersListRecyclerviewItemBinding) :
        RecyclerView.ViewHolder(binding.root)
}
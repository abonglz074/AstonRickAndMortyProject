package com.mytestprogram.astonrickandmortyproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.mytestprogram.astonrickandmortyproject.databinding.SingleItemListCharactersBinding

//class ListCharactersAdapter :
//    RecyclerView.Adapter<ListCharactersAdapter.ListCharactersViewHolder>() {
//
//
//    inner class ListCharactersViewHolder(val binding: SingleItemListCharactersBinding) :
//        RecyclerView.ViewHolder(binding.root)
//
//    private val diffCallback = object : DiffUtil.ItemCallback<Character>() {
//
//        override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    private val differ = AsyncListDiffer(this, diffCallback)
//    var characters: List<Character>
//        get() = differ.currentList
//        set(value) {
//            differ.submitList(value)
//        }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCharactersViewHolder {
//        return ListCharactersViewHolder(
//            SingleItemListCharactersBinding.inflate(
//                LayoutInflater.from(parent.context),
//                parent,
//                false
//            )
//        )
//    }
//
//    override fun onBindViewHolder(holder: ListCharactersViewHolder, position: Int) {
//        holder.binding.apply {
//            val character = characters[position]
//            characterImageView.setImageResource()
//            characterNameTextView.text = character.name
//            characterSpeciesTextView.text = character.species
//            characterGenderTextView.text = character.gender
//            characterStatusTextView.text = character.status
//        }
//    }
//
////    override fun getItemCount(): Int = characters.size
//
//
//}
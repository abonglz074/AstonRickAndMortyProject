package com.mytestprogram.astonrickandmortyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mytestprogram.astonrickandmortyproject.databinding.ActivityMainBinding
import com.mytestprogram.astonrickandmortyproject.screens.characters.CharacterDetailsFragment
import com.mytestprogram.astonrickandmortyproject.screens.locations.ListLocationsFragment

class MainActivity : AppCompatActivity(), NavigatorInterface {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ListLocationsFragment())
                .commit()
        }

    }

    override fun showCharacterDetails(characterId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CharacterDetailsFragment.newInstance(characterId))
            .addToBackStack(null)
            .commit()
    }

    override fun showLocationsList() {
        TODO("Not yet implemented")
    }

    override fun showEpisodesList() {
        TODO("Not yet implemented")
    }

    override fun showLocationDetails() {
        TODO("Not yet implemented")
    }

    override fun showEpisodeDetails() {
        TODO("Not yet implemented")
    }
}
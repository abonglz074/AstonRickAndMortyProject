package com.mytestprogram.astonrickandmortyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.children
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.mytestprogram.astonrickandmortyproject.databinding.ActivityMainBinding
import com.mytestprogram.astonrickandmortyproject.screens.characters.details.CharacterDetailsFragment
import com.mytestprogram.astonrickandmortyproject.screens.characters.lists.ListCharactersFragment
import com.mytestprogram.astonrickandmortyproject.screens.episodes.details.EpisodeDetailsFragment
import com.mytestprogram.astonrickandmortyproject.screens.episodes.lists.ListEpisodesFragment
import com.mytestprogram.astonrickandmortyproject.screens.locations.details.LocationDetailsFragment
import com.mytestprogram.astonrickandmortyproject.screens.locations.lists.ListLocationsFragment

class MainActivity : AppCompatActivity(), NavigatorInterface {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        actionBar?.setDisplayHomeAsUpEnabled(false)

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.ic_characters -> {
                    showCharactersList()
                }
                R.id.ic_locations -> {
                    showLocationsList()
                }
                R.id.ic_episodes -> {
                    showEpisodesList()
                }
            }
            return@setOnItemSelectedListener true
        }


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ListCharactersFragment())
                .commit()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun showCharactersList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ListCharactersFragment())
            .commit()

        actionBar?.setDisplayHomeAsUpEnabled(false)

    }

    override fun showCharacterDetails(characterId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CharacterDetailsFragment.newInstance(characterId))
            .addToBackStack(null)
            .commit()

        actionBar?.setDisplayHomeAsUpEnabled(true)


    }

    override fun showLocationsList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ListLocationsFragment())
            .commit()
    }

    override fun showEpisodesList() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ListEpisodesFragment())
            .commit()
    }


    override fun showEpisodeDetails(episodeId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, EpisodeDetailsFragment.newInstance(episodeId))
            .addToBackStack(null)
            .commit()
    }

    override fun showLocationDetails(locationId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LocationDetailsFragment.newInstance(locationId))
            .addToBackStack(null)
            .commit()
    }

    override fun goBack() {
        onBackPressed()
    }

    fun bottomNavigationGone() {
        binding.bottomNavigation.visibility = View.GONE
    }

    fun bottomNavigationVisible() {
        binding.bottomNavigation.visibility = View.VISIBLE
    }
}
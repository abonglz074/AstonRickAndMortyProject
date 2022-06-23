package com.mytestprogram.astonrickandmortyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ListLocationsFragment())
                .commit()
        }
        binding.bottomNavigation.visibility = View.VISIBLE

    }


    override fun showCharacterDetails(characterId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CharacterDetailsFragment.newInstance(characterId))
            .addToBackStack(null)
            .commit()

        binding.bottomNavigation.visibility = View.GONE
    }

    override fun showLocationsList() {

    }

    override fun showEpisodesList() {
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.fragment_container, )
    }


    override fun showEpisodeDetails(episodeId: Int) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, EpisodeDetailsFragment.newInstance(episodeId))
            .addToBackStack(null)
            .commit()
        binding.bottomNavigation.visibility = View.GONE
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
}
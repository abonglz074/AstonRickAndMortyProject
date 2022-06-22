package com.mytestprogram.astonrickandmortyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.mytestprogram.astonrickandmortyproject.data.models.allcharactersresponse.SingleCharacter
import com.mytestprogram.astonrickandmortyproject.data.models.allepisodesresponse.SingleEpisode
import com.mytestprogram.astonrickandmortyproject.data.models.alllocationsresponse.SingleLocation
import com.mytestprogram.astonrickandmortyproject.databinding.ActivityMainBinding
import com.mytestprogram.astonrickandmortyproject.screens.characters.details.CharacterDetailsFragment
import com.mytestprogram.astonrickandmortyproject.screens.characters.lists.ListCharactersFragment
import com.mytestprogram.astonrickandmortyproject.screens.episodes.details.EpisodeDetailsFragment
import com.mytestprogram.astonrickandmortyproject.screens.locations.details.LocationDetailsFragment

class MainActivity : AppCompatActivity(), NavigatorInterface {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, ListCharactersFragment())
                .commit()
        }
        binding.bottomNavigation.visibility = View.VISIBLE

    }


    override fun showCharacterDetails(singleCharacter: SingleCharacter) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, CharacterDetailsFragment.newInstance(singleCharacter.id))
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

    override fun showLocationDetails(singleLocation: SingleLocation) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, LocationDetailsFragment.newInstance(singleLocation.id))
            .addToBackStack(null)
            .commit()
        binding.bottomNavigation.visibility = View.GONE
    }

    override fun showEpisodeDetails(singleEpisode: SingleEpisode) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, EpisodeDetailsFragment.newInstance(singleEpisode.id))
            .addToBackStack(null)
            .commit()
        binding.bottomNavigation.visibility = View.GONE
    }

    override fun goBack() {
        onBackPressed()
    }
}
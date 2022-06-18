package com.mytestprogram.astonrickandmortyproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mytestprogram.astonrickandmortyproject.databinding.ActivityMainBinding
import com.squareup.moshi.Moshi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val moshi = Moshi.Builder().build()

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/api/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        val service = retrofit.create(RetrofitService::class.java)

        service.getCharacterById().enqueue(object : Callback<GetCharacterByIdResponse> {
            override fun onResponse(
                call: Call<GetCharacterByIdResponse>,
                response: Response<GetCharacterByIdResponse>
            ) {
                val body = response.body()!!
                val name = body.name

                binding.testTextID.text = name


            }

            override fun onFailure(call: Call<GetCharacterByIdResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }
}
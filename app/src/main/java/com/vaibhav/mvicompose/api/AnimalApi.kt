package com.vaibhav.mvicompose.api

import com.vaibhav.mvicompose.model.Animal
import retrofit2.http.GET

interface AnimalApi {
	@GET("animals.json")
	suspend fun getAnimals(): List<Animal>
}
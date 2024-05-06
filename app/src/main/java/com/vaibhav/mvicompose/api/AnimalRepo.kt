package com.vaibhav.mvicompose.api

class AnimalRepo(private val api: AnimalApi) {
	suspend fun getAnimal() = api.getAnimals()
	
}
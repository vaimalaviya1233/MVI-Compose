package com.vaibhav.mvicompose.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vaibhav.mvicompose.api.AnimalApi
import com.vaibhav.mvicompose.api.AnimalRepo

class ViewModelFactory(private val api: AnimalApi): ViewModelProvider.Factory {
	override fun <T : ViewModel> create(modelClass: Class<T>): T {
		if(modelClass.isAssignableFrom(MainViewModel::class.java)){
			return MainViewModel(AnimalRepo(api)) as T
		}
		throw IllegalArgumentException("Unknown class name")
	}
}
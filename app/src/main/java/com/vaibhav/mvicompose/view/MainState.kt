package com.vaibhav.mvicompose.view

import com.vaibhav.mvicompose.model.Animal

sealed class MainState {
	object Idle: MainState()
	object Loading: MainState()
	data class Animals(val Animals: List<Animal>) : MainState()
	data class Error(val error: String?): MainState()
}
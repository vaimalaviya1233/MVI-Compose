package com.vaibhav.mvicompose.view

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vaibhav.mvicompose.api.AnimalRepo
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MainViewModel(private val repo: AnimalRepo): ViewModel() {
	val userIntent = Channel<MainIntent>(Channel.UNLIMITED)
	var state = mutableStateOf<MainState>(MainState.Idle)
		private set
	
	init{
		handleIntent()
	}
	
	private fun handleIntent() {
		viewModelScope.launch {
			userIntent.consumeAsFlow().collect{ collector ->
				when(collector){
					is MainIntent.FetchAnimals -> fetchAnimals()
				}
			}
		}
	}
	
	private fun fetchAnimals() {
		viewModelScope.launch {
			state.value = MainState.Loading
			state.value = try {
				MainState.Animals(repo.getAnimal())
			}catch(e: Exception){
				MainState.Error(e.localizedMessage)
			}
		}
	}
}
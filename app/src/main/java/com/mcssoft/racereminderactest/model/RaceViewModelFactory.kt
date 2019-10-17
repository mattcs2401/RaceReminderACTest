package com.mcssoft.racereminderactest.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mcssoft.racereminderactest.repository.RacesRepository

/**
 * Utility class to pass constructor parameter for a ViewModel.
 */
@Suppress("UNCHECKED_CAST")
class RaceViewModelFactory(private val repository: RacesRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RaceViewModel(repository) as T
    }
}
package com.mcssoft.racereminderactest.model

import androidx.lifecycle.ViewModel
import com.mcssoft.racereminderactest.entity.Race
import com.mcssoft.racereminderactest.repository.RacesRepository

class RaceViewModel(private val repository: RacesRepository) : ViewModel() {

    fun getAllRaces() = repository.getAllRaces()

    fun swapData(lRaces: MutableList<Race>) = repository.swapData(lRaces)
}

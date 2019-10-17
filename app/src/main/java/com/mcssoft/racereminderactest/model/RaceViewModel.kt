package com.mcssoft.racereminderactest.model

import androidx.lifecycle.ViewModel
import com.mcssoft.racereminderactest.entity.Race
import com.mcssoft.racereminderactest.repository.RacesRepository

class RaceViewModel(private val repository: RacesRepository) : ViewModel() {

    val getAllRaces = repository.getAllRaces

    fun swapData(lRaces: MutableList<Race>) = repository.swapData(lRaces)

    fun insertRace(race: Race) = repository.insertRace(race)

    fun updateRace(race: Race) = repository.updateRace(race)

    fun deleteRace(race: Race) = repository.deleteRace(race)
}

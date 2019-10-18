package com.mcssoft.racereminderactest.model

import androidx.lifecycle.ViewModel
import com.mcssoft.racereminderactest.entity.Race
import com.mcssoft.racereminderactest.repository.RacesRepository

class RaceViewModel(private val repository: RacesRepository) : ViewModel() {

    val getAllRaces = repository.getAllRaces

    fun setData(lRaces: MutableList<Race>) = repository.setData(lRaces)

    fun insertRace(race: Race): Long = repository.insertRace(race)

    fun updateRace(race: Race) = repository.updateRace(race)

    fun deleteRace(race: Race) = repository.deleteRace(race)

    fun getRace(ndx: Int): Race = repository.getRace(ndx)

    fun getCount(): Int = repository.getRaceCount()

    fun deleteAt(ndx: Int) = repository.deleteAt(ndx)

    fun isEmpty(): Boolean = repository.isEmpty()

    fun notifyChange() {
        // TBA
    }
}

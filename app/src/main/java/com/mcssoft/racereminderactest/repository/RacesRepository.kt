package com.mcssoft.racereminderactest.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mcssoft.racereminderactest.dao.RacesDAO
import com.mcssoft.racereminderactest.database.RaceDatabase
import com.mcssoft.racereminderactest.entity.Race

class RacesRepository() {
    constructor(application: Application) : this() {
        racesDao = RaceDatabase.getInstance(application)!!.racesDao()
        update()
        val bp = "bp"
    }

    val getAllRaces
    get() = lRaces

    fun swapData(lRaces: MutableList<Race>) {
        _lRaces.setValue(lRaces)
    }

    fun insertRace(race: Race): Long {
        val id = racesDao.insertRace(race)
        update()
        return  id
    }

    fun updateRace(race: Race) {
        racesDao.updateRace(race)
    }

    fun deleteRace(race: Race) {
        racesDao.deleteRace(race)
        update()
    }

    fun getRace(ndx: Int): Race = _lRaces.value!!.get(ndx)

    fun getRaceCount(): Int = _lRaces.value!!.size

    fun deleteAt(ndx: Int) {
        // TBA
    }

    fun isEmpty(): Boolean = _lRaces.value!!.size > 0

    private val lRaces : LiveData<MutableList<Race>>
        get() = _lRaces

    private fun update() {
        _lRaces = MutableLiveData<MutableList<Race>>(racesDao.getAllRaces().value)
    }

    private lateinit var racesDao: RacesDAO
    private lateinit var _lRaces: MutableLiveData<MutableList<Race>>
}

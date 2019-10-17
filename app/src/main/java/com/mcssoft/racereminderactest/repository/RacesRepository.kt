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
        _lRaces = MutableLiveData<MutableList<Race>>(racesDao.getAllRaces().value)
        val bp = "bp"
    }

    val getAllRaces
    get() = lRaces

    fun swapData(lRaces: MutableList<Race>) {
        _lRaces.setValue(lRaces)
    }

    fun insertRace(race: Race) {
        racesDao.insertRace(race)
    }

    fun updateRace(race: Race) {
        racesDao.updateRace(race)
    }

    fun deleteRace(race: Race) {
        racesDao.deleteRace(race)
    }

    private val lRaces : LiveData<MutableList<Race>>
        get() = _lRaces

    private lateinit var racesDao: RacesDAO
    private lateinit var _lRaces: MutableLiveData<MutableList<Race>>
}

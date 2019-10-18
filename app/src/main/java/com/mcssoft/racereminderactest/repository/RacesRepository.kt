package com.mcssoft.racereminderactest.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mcssoft.racereminderactest.background.RacesInsertTask
import com.mcssoft.racereminderactest.dao.RacesDAO
import com.mcssoft.racereminderactest.database.RaceDatabase
import com.mcssoft.racereminderactest.entity.Race

class RacesRepository() {
    constructor(application: Application) : this() {
        racesDao = RaceDatabase.getInstance(application)!!.racesDao()
        lRaces = racesDao.getAllRaces()

        _lRaces = mutableListOf<Race>()
        _lRaces.add(Race("Dummy"))
    }

    val getAllRaces
    get() = lRaces

    fun setData(lRaces: MutableList<Race>) {
        _lRaces = lRaces
    }

    fun insertRace(race: Race): Long {
        val racesAsync = RacesInsertTask(racesDao)
        racesAsync.execute(race)
        return  racesAsync.get() as Long
    }

    fun updateRace(race: Race) {
        racesDao.updateRace(race)
    }

    fun deleteRace(race: Race) {
        racesDao.deleteRace(race)
    }

    fun getRace(ndx: Int): Race {
        if(_lRaces.size > 0) {
            return _lRaces.get(ndx)
        }
        return Race("")
    }

    // TODO - the adapter is calling this before the observer onChange sets the data.
    fun getRaceCount(): Int {
        return _lRaces.size
    }

    fun deleteAt(ndx: Int) {
        // TBA
    }

    fun isEmpty(): Boolean = _lRaces.size > 0

    private lateinit var lRaces : LiveData<MutableList<Race>>
    private lateinit var _lRaces: MutableList<Race>
    private lateinit var racesDao: RacesDAO
}

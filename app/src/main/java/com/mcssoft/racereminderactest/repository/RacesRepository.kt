package com.mcssoft.racereminderactest.repository

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mcssoft.racereminderactest.dao.RacesDAO
import com.mcssoft.racereminderactest.database.RaceDatabase
import com.mcssoft.racereminderactest.entity.Race

class RacesRepository() {


    private var _lRaces = MutableLiveData<MutableList<Race>>()
    val lRaces : LiveData<MutableList<Race>>
        get() = _lRaces

    constructor(application: Application) : this() {
        // Note: Used in the ViewModel for the MainFragment.
        racesDao = RaceDatabase.getInstance(application)!!.racesDao()
        _lRaces = getlRaces()
        val bp = "bp"
    }

    fun getAllRaces() = lRaces

    fun swapData(lRaces: MutableList<Race>) {
        _lRaces.setValue(lRaces)
    }

    private fun getlRaces(): MutableLiveData<MutableList<Race>> {
        val races: LiveData<MutableList<Race>> = racesDao.getAllRaces()
        return MutableLiveData<MutableList<Race>>(races.value)
    }

    private lateinit var racesDao: RacesDAO

//    private val _score = MutableLiveData<Int>()
//    val score: LiveData<Int>
//        get() = _score
}

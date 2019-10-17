package com.mcssoft.racereminderactest.background

import android.os.AsyncTask
import com.mcssoft.racereminderactest.dao.RacesDAO
import com.mcssoft.racereminderactest.entity.Race

class RacesInsertTask(private val racesDao: RacesDAO) : AsyncTask<Race, Void, Long>() {

    override fun doInBackground(vararg params: Race): Long {
        return racesDao.insertRace(params[0])
    }
}
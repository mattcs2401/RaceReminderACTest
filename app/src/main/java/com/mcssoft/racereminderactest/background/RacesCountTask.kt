package com.mcssoft.racereminderactest.background

import android.os.AsyncTask
import com.mcssoft.racereminderactest.dao.RacesDAO
import com.mcssoft.racereminderactest.entity.Race

class RacesCountTask(private val racesDao: RacesDAO) : AsyncTask<Void, Void, Int>() {

    override fun doInBackground(vararg params: Void?): Int {
        return racesDao.getCount()
    }
}
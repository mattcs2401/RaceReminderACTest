package com.mcssoft.racereminderactest.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room
import androidx.sqlite.db.SupportSQLiteDatabase
import com.mcssoft.racereminderactest.dao.RacesDAO
import com.mcssoft.racereminderactest.entity.Race
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Database(entities = [Race::class], version = 1, exportSchema = false)
abstract class RaceDatabase: RoomDatabase() {

    internal abstract fun racesDao(): RacesDAO

    companion object {
        @Volatile
        private var instance: RaceDatabase? = null

        fun getInstance(context: Application?): RaceDatabase? {
            if (instance == null) {
                synchronized(RaceDatabase::class) {
                    instance = Room.databaseBuilder(
                        context!!.applicationContext,
                        RaceDatabase::class.java, "Races.db"
                    )
                        .fallbackToDestructiveMigration()
                        .addCallback(object : RoomDatabase.Callback() {
                            override fun onCreate(db: SupportSQLiteDatabase) {
                                fillInDb(context.applicationContext)
                            }
                        })
                        .build()
                }
            }
            return instance
        }

        private fun fillInDb(context: Context) {
            GlobalScope.launch {
                getInstance(context.applicationContext as Application?)?.racesDao()!!.insertRaces(
                    dummyData
                )
            }
        }

    }
}
private val dummyData = arrayListOf<Race>(
    Race("Race name 1"),
    Race("Race name 2"),
    Race("Race name 3"),
    Race("Race name 4"),
    Race("Race name 5"),
    Race("Race name 6"),
    Race("Race name 7"),
    Race("Race name 8"),
    Race("Race name 9")

)
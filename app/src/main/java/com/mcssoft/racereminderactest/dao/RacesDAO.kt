package com.mcssoft.racereminderactest.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.mcssoft.racereminderactest.entity.Race

@Dao
interface RacesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRace(race: Race): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRaces(races: List<Race>): List<Long>

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateRace(race: Race): Int

    @Delete
    fun deleteRace(race: Race)

    @Query("select * from races")
    fun getAllRaces(): LiveData<MutableList<Race>>

    @Query("select count(*) from races")
    fun getCount(): Int

}
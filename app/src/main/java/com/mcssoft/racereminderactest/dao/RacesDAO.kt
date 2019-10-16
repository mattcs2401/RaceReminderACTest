package com.mcssoft.racereminderactest.dao

import androidx.room.*
import com.mcssoft.racereminderactest.entity.Race

@Dao
interface RacesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRace(race: Race): Long

    @Update(onConflict = OnConflictStrategy.IGNORE)
    fun updateRace(race: Race): Int

    @Delete
    fun deleteRace(race: Race)
}
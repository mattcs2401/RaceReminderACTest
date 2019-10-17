package com.mcssoft.racereminderactest.interfaces

import com.mcssoft.racereminderactest.entity.Race

/**
 * Interface between the MainFragment and RaceDetailsAdapter to reference RaceViewModel -> RaceRepository
 * functionality.
 */
interface IRepository {

    /**
     * Get the count of RaceDetails in the backing data.
     * @return Count value.
     */
    fun getCount() : Int

    /**
     * Get a RaceDetails object from the backing data at position.
     * @param ndx: A list index into the backing data (position).
     * @return The RaceDetails object.
     */
    fun getAt(ndx: Int): Race

    /**
     * Insert the given RaceDetails.
     * @param raceDetails: The RaceDetails to insert.
     */
    fun insert(raceDetails: Race) : Long

    /**
     * Delete the RaceDetails that corresponds to the backing data position.
     * @param ndx: A list index into the backing data (position).
     */
    fun deleteAt(ndx: Int)
}
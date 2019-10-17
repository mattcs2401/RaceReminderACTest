package com.mcssoft.racereminderactest.observer

import androidx.lifecycle.Observer
import com.mcssoft.racereminderactest.entity.Race
import com.mcssoft.racereminderactest.model.RaceViewModel

class RaceListObserver(private var raceViewModel: RaceViewModel) : Observer<MutableList<Race>> {

    override fun onChanged(lRaces: MutableList<Race>?) {
        if(lRaces != null) {
            if(lRaces.size > 1) {
                lRaces.sortedBy { it.raceName }
            }
            raceViewModel.setData(lRaces)
        }
    }
}
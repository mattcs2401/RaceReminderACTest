package com.mcssoft.racereminderactest.observer

import androidx.lifecycle.Observer
import com.mcssoft.racereminderactest.entity.Race
import com.mcssoft.racereminderactest.model.RaceViewModel
import com.mcssoft.racereminderactest.utility.NotifyUpdateMessage
import org.greenrobot.eventbus.EventBus

class RaceListObserver(private var raceViewModel: RaceViewModel) : Observer<MutableList<Race>> {

    override fun onChanged(lRaces: MutableList<Race>?) {
        if(lRaces != null) {
            if(lRaces.size > 1) {
                lRaces.sortedBy { it.raceName }
            }
            raceViewModel.setData(lRaces)

            EventBus.getDefault().post(NotifyUpdateMessage())
        }
    }
}
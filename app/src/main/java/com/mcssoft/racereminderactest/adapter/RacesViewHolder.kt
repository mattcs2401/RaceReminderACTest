package com.mcssoft.racereminderactest.adapter

import android.view.View
import com.mcssoft.racereminderactest.adapter.base.ParentViewHolder
import com.mcssoft.racereminderactest.entity.Race

class RacesViewHolder(private val view: View) : ParentViewHolder(view) {

    internal fun bind(race: Race, position: Int) {
//        // Instantiate viewholder components.
//        setDisplayElements(race)
//        // Set view holder component values.
//        setBaseDisplayValues(race, position)
//        // Set view holder component values for multi select.
//        setMultiSelect(race)
    }

    override fun onClick(view: View) {
        super.onClick(view)
    }
}
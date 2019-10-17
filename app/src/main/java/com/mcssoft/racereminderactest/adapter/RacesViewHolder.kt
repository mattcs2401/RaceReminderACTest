package com.mcssoft.racereminderactest.adapter

import android.view.View
import android.widget.TextView
import com.mcssoft.racereminderactest.adapter.base.ParentViewHolder
import com.mcssoft.racereminderactest.entity.Race
import kotlinx.android.synthetic.main.row_race.view.*

class RacesViewHolder(private val view: View) : ParentViewHolder(view) {

    internal fun bind(race: Race, position: Int) {
        if(race.raceName != "") {
            tvRaceName = view.id_tv_racename
            tvRaceName.text = race.raceName
        }
    }

    override fun onClick(view: View) {
        super.onClick(view)
    }

    private lateinit var tvRaceName: TextView
}
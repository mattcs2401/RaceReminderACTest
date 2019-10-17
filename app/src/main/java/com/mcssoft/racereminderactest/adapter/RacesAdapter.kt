package com.mcssoft.racereminderactest.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mcssoft.racereminderactest.R
import com.mcssoft.racereminderactest.interfaces.IRepository
import com.mcssoft.racereminderactest.interfaces.ISwipe

class RacesAdapter(private val iRepo: IRepository) :
    RecyclerView.Adapter<RacesViewHolder>(), ISwipe {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : RacesViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.row_race, parent, false)
        Log.d("TAG","RaceDetailsAdapter.onCreateViewHolder")
        return RacesViewHolder(view)
    }

    override fun onBindViewHolder(holder : RacesViewHolder, position : Int) {
        holder.bind(iRepo.getAt(position), position)
        Log.d("TAG","RaceDetailsAdapter.onBindViewHolder")
    }

    override fun getItemCount() : Int = iRepo.getCount()

    //<editor-fold default state="collapsed" desc="Region: Interface - ISwipe">
    /**
     * Interface ISwipe.
     */
    override fun onViewSwiped(pos: Int) {
        // Delete from the backing data.
        iRepo.deleteAt(pos)
        // Notify the adapter.
        notifyItemRemoved(pos)    }
    //</editor-fold> {
}
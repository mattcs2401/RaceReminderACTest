package com.mcssoft.racereminderactest.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mcssoft.racereminderactest.R
import com.mcssoft.racereminderactest.adapter.RacesAdapter
import com.mcssoft.racereminderactest.entity.Race
import com.mcssoft.racereminderactest.interfaces.IRepository
import com.mcssoft.racereminderactest.repository.RacesRepository
import com.mcssoft.racereminderactest.model.RaceViewModel
import com.mcssoft.racereminderactest.model.RaceViewModelFactory
import com.mcssoft.racereminderactest.observer.RaceListObserver
import kotlinx.android.synthetic.main.main_fragment.view.*

class MainFragment : Fragment(), IRepository, View.OnClickListener {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var raceViewModel: RaceViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.id_recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)

        raceRepo = RacesRepository(activity!!.application)

        fab = view.id_fab
        fab.setOnClickListener(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Set the view model and observe.
        raceViewModel = ViewModelProviders
            .of(this, RaceViewModelFactory(raceRepo))
            .get(RaceViewModel::class.java)

        raceObserver = RaceListObserver(raceViewModel)

        raceViewModel.getAllRaces.observe(viewLifecycleOwner, raceObserver)

        raceAdapter = RacesAdapter(this)
        recyclerView.adapter = raceAdapter
    }

    override fun onStart() {
        super.onStart()
        raceAdapter.notifyDataSetChanged()
//        raceAdapter = RacesAdapter(this)
//        recyclerView.adapter = raceAdapter
    }

    override fun onClick(view: View) {
        when(view.id) {
            R.id.id_fab -> {
                val race = Race("Race name 1")
                insert(race)
            } else -> {}
        }

    }

    //<editor-fold default state="collapsed" desc="Region: IRepository">
    override fun getCount(): Int = raceViewModel.getCount()

    override fun getAt(ndx: Int): Race = raceViewModel.getRace(ndx)

    override fun insert(race: Race) : Long = raceViewModel.insertRace(race)

    override fun deleteAt(ndx: Int) {
        raceViewModel.deleteAt(ndx)
        if(raceViewModel.isEmpty()) {
            // TBA
//            setDeleteMenuItem(false)
        }
    }
    //</editor-fold>


    private lateinit var raceAdapter: RacesAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var fab: FloatingActionButton
    private lateinit var raceRepo: RacesRepository
    private lateinit var raceObserver: RaceListObserver
}

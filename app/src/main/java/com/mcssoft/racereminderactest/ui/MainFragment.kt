package com.mcssoft.racereminderactest.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mcssoft.racereminderactest.R
import com.mcssoft.racereminderactest.adapter.RacesAdapter
import com.mcssoft.racereminderactest.entity.Race
import com.mcssoft.racereminderactest.interfaces.IRepository
import com.mcssoft.racereminderactest.repository.RacesRepository
import com.mcssoft.racereminderactest.model.RaceViewModel
import com.mcssoft.racereminderactest.model.RaceViewModelFactory
import com.mcssoft.racereminderactest.observer.RaceListObserver
import kotlinx.android.synthetic.main.main_fragment.view.*

class MainFragment : Fragment(), IRepository {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var raceViewModel: RaceViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        raceAdapter = RacesAdapter(this)
        recyclerView = view.id_recyclerView
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = raceAdapter
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Set the view model and observe.
        raceViewModel = ViewModelProviders
            .of(this, RaceViewModelFactory(RacesRepository(activity!!.application)))
            .get(RaceViewModel::class.java)

        raceViewModel.getAllRaces.observe(viewLifecycleOwner, RaceListObserver(raceViewModel))


    }

    //<editor-fold default state="collapsed" desc="Region: IRepository">
    override fun getCount(): Int = raceViewModel.getRaceCount()

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
}

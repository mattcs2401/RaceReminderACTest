package com.mcssoft.racereminderactest.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mcssoft.racereminderactest.R
import com.mcssoft.racereminderactest.repository.RacesRepository
import com.mcssoft.racereminderactest.model.RaceViewModel
import com.mcssoft.racereminderactest.model.RaceViewModelFactory
import com.mcssoft.racereminderactest.observer.RaceListObserver

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var raceViewModel: RaceViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // Set the view model and observe.
        raceViewModel = ViewModelProviders
            .of(this, RaceViewModelFactory(RacesRepository(activity!!.application)))
            .get(RaceViewModel::class.java)

        raceViewModel.getAllRaces.observe(viewLifecycleOwner, RaceListObserver(raceViewModel))



    }

}
package com.example.android.project05_nd_tourguideme;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class CastlesFragment extends Fragment {

    public CastlesFragment() {

        //required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);

        // Create an array of words
        final ArrayList<Place> place = new ArrayList<>();

// Add castles
        place.add(new Place(getString(R.string.category_castles), getString(R.string.nameBitov), getString(R.string.infoBitov), getString(R.string.phoneBitov),
                getString(R.string.webBitov), getString(R.string.emailBitov), getString(R.string.addressBitov),
                getString(R.string.quoteBitov), R.drawable.castle_bitov));

        place.add(new Place(getString(R.string.category_castles), getString(R.string.nameJaromerice), getString(R.string.infoJaromerice), getString(R.string.phoneJaromerice),
                getString(R.string.webJaromerice), getString(R.string.emailJaromerice), getString(R.string.addressJaromerice),
                getString(R.string.quoteJaromerice), R.drawable.castle_jaromerice));

        place.add(new Place(getString(R.string.category_castles), getString(R.string.nameValtice), getString(R.string.infoValtice), getString(R.string.phoneValtice),
                getString(R.string.webValtice), getString(R.string.emailValtice), getString(R.string.addressValtice),
                getString(R.string.quoteValtice), R.drawable.castle_valtice));

        place.add(new Place(getString(R.string.category_castles), getString(R.string.nameVranov), getString(R.string.infoVranov), getString(R.string.phoneVranov),
                getString(R.string.webVranov), getString(R.string.emailVranov), getString(R.string.addressVranov),
                getString(R.string.quoteVranov), R.drawable.castle_vranov_nad_diji));

        // Create an {@link placeAdapter}, whose data source is a list of {@link Place}s. The
        // adapter knows how to create list items for each item in the list.
        PlaceAdapter placeAdapter = new PlaceAdapter(getActivity(), place);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        ListView listView = rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PlaceAdapter} created above, so that the
        // {@link ListView} will display list items for each {@link Place} in the list.
        listView.setAdapter(placeAdapter);

        return rootView;
    }
}

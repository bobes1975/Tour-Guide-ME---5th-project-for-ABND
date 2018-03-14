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

public class CavesFragment extends Fragment {

    /**
     * Handles playback of all sound files
     */
    public CavesFragment() {

        //required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);

        // Create an array of words
        final ArrayList<Place> place = new ArrayList<>();

        // Add caves

        place.add(new Place(getString(R.string.category_caves),getString(R.string.nameMacocha),getString(R.string.infoMacocha), getString(R.string.phoneMacocha),
                getString(R.string.webMacocha),getString(R.string.emailMacocha),getString(R.string.addressMacocha),
                getString(R.string.quoteMacocha),R.drawable.cave_macocha));

        place.add(new Place(getString(R.string.category_caves),getString(R.string.namePunkva),getString(R.string.infoPunkva), getString(R.string.phonePunkva),
                getString(R.string.webPunkva),getString(R.string.emailPunkva),getString(R.string.addressPunkva),
                getString(R.string.quotePunkva),R.drawable.cave_punkva));

        place.add(new Place(getString(R.string.category_caves),getString(R.string.nameTurold),getString(R.string.infoTurold), getString(R.string.phoneTurold),
                getString(R.string.webTurold),getString(R.string.emailTurold),getString(R.string.addressTurold),
                getString(R.string.quoteTurold),R.drawable.cave_turold));

        place.add(new Place(getString(R.string.category_caves),getString(R.string.nameBozkov),getString(R.string.infoBozkov), getString(R.string.phoneBozkov),
                getString(R.string.webBozkov),getString(R.string.emailBozkov),getString(R.string.addressBozkov),
                getString(R.string.quoteBozkov),R.drawable.cave_bozkov));

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

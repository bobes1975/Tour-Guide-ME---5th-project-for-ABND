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

public class ArchitectureFragment extends Fragment {

    public ArchitectureFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.list_layout, container, false);

        // Create an array of place
        final ArrayList<Place> place = new ArrayList<>();

        // Add architecture
        //category, name, info, phone, web, email, address, quote, image
        place.add(new Place(getString(R.string.category_architecture), getString(R.string.nameTugendhat), getString(R.string.infoTugendhat), getString(R.string.phoneTugendhat),
                getString(R.string.webTugendhat), getString(R.string.emailTugendhat), getString(R.string.addressTugendhat),
                getString(R.string.quoteTugendhat), R.drawable.arch_tugendhat));

        place.add(new Place(getString(R.string.category_architecture), getString(R.string.nameJurkovic), getString(R.string.infoJurkovic), getString(R.string.phoneJurkovic),
                getString(R.string.webJurkovic), getString(R.string.emailJurkovic), getString(R.string.addressJurkovic),
                getString(R.string.quoteJurkovic), R.drawable.arch_jurkovic));

        place.add(new Place(getString(R.string.category_architecture), getString(R.string.nameLow), getString(R.string.infoLow), getString(R.string.phoneLow),
                getString(R.string.webLow), getString(R.string.emailLow), getString(R.string.addressLow),
                getString(R.string.quoteLow), R.drawable.arch_low));

        place.add(new Place(getString(R.string.category_architecture), getString(R.string.nameStiassni), getString(R.string.infoStiassni), getString(R.string.phoneStiassni),
                getString(R.string.webStiassni), getString(R.string.emailStiassni), getString(R.string.addressStiassni),
                getString(R.string.quoteStiassni), R.drawable.arch_stiassni));

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

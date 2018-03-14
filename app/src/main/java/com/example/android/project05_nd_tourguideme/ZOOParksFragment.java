package com.example.android.project05_nd_tourguideme;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class ZOOParksFragment extends Fragment {

    public ZOOParksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.list_layout, container, false);

        // Create an array of words
        final ArrayList<Place> place = new ArrayList<>();

        // Add zoo parks
        place.add(new Place(getString(R.string.category_zoo), getString(R.string.nameVyskov), getString(R.string.infoVyskov), getString(R.string.phoneVyskov),
                getString(R.string.webVyskov), getString(R.string.emailVyskov), getString(R.string.addressVyskov),
                getString(R.string.quoteVyskov), R.drawable.zoo_vyskov));

        place.add(new Place(getString(R.string.category_zoo), getString(R.string.nameJihlava), getString(R.string.infoJihlava), getString(R.string.phoneJihlava),
                getString(R.string.webJihlava), getString(R.string.emailJihlava), getString(R.string.addressJihlava),
                getString(R.string.quoteJihlava), R.drawable.zoo_jihlava));

        place.add(new Place(getString(R.string.category_zoo), getString(R.string.nameDvurKralove), getString(R.string.infoDvurKralove), getString(R.string.phoneDvurKralove),
                getString(R.string.webDvurKralove), getString(R.string.emailDvurKralove), getString(R.string.addressDvurKralove),
                getString(R.string.quoteDvurKralove), R.drawable.zoo_dvur_kralove));

        place.add(new Place(getString(R.string.category_zoo), getString(R.string.nameOstrava), getString(R.string.infoOstrava), getString(R.string.phoneOstrava),
                getString(R.string.webOstrava), getString(R.string.emailOstrava), getString(R.string.addressOstrava),
                getString(R.string.quoteOstrava), R.drawable.zoo_ostrava));


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

package com.example.android.project05_nd_tourguideme;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PlaceAdapter extends ArrayAdapter<Place> {

    private Context context = getContext();

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context     The current context. Used to inflate the layout file.
     * @param place A List of composition, author and picture objects to display in a list
     */
    public PlaceAdapter(Activity context, ArrayList<Place> place) {
        super(context, 0, place);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Place} object located at this position in the list
        Place currentPlace = getItem(position);

        // Find the TextView in the place_list.xml layout with the ID version_name
        TextView locationTextView = listItemView.findViewById(R.id.namePlace);

        // Get the version name from the current object and
        // set this text on the name TextView
        assert currentPlace != null;
        locationTextView.setText(currentPlace.getNamePlace());

        // Find the TextView in the place_list.xml layout with the ID version_name
        TextView quoteTextView = listItemView.findViewById(R.id.quotePlace);

        // Get the version name from the current object and
        // set this text on the name TextView

        quoteTextView.setText(currentPlace.getQuotePlace());

        //Find ImageView in the composition_list.xml layout with the ID version_name
        ImageView imagePlace = listItemView.findViewById(R.id.imagePlace);

        // Check if an image is provided for this composer or not
        if (currentPlace.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imagePlace.setImageResource(currentPlace.getImageResourceId());
            // Make sure the view is visible
            imagePlace.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imagePlace.setVisibility(View.GONE);
        }

        //Get the place properties - category, name, address, info, phone, web, email, quote, image
        String categoryPlaceDetail = currentPlace.getCategoryPlace();
        String namePlaceDetail = currentPlace.getNamePlace();
        String addressPlaceDetail = currentPlace.getAddressPlace();
        String infoPlaceDetail = currentPlace.getInfoPlace();
        String phonePlaceDetail = currentPlace.getPhonePlace();
        String webPlaceDetail = currentPlace.getWebPlace();
        String emailPlaceDetail = currentPlace.getEmailPlace();
        int imagePlaceDetail = currentPlace.getImageResourceId();

        //Create an implicit intent to display the detailed place information if the user taps on the list item
        final Intent itemIntent = new Intent(context, PlaceDetailsLayoutActivity.class);

        //Put the properties of the Object to the intent
        itemIntent.putExtra(context.getString(R.string.category), categoryPlaceDetail);
        itemIntent.putExtra(context.getString(R.string.place), namePlaceDetail);
        itemIntent.putExtra(context.getString(R.string.address), addressPlaceDetail);
        itemIntent.putExtra(context.getString(R.string.info), infoPlaceDetail);
        itemIntent.putExtra(context.getString(R.string.phone), phonePlaceDetail);
        itemIntent.putExtra(context.getString(R.string.web), webPlaceDetail);
        itemIntent.putExtra(context.getString(R.string.email), emailPlaceDetail);
        itemIntent.putExtra(context.getString(R.string.picture), imagePlaceDetail);

        //Start the intent if the user taps on the list item
        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(itemIntent);
            }});

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return listItemView;
    }
}
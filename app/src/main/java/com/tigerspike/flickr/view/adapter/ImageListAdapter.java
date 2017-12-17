package com.tigerspike.flickr.view.adapter;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.tigerspike.flickr.R;
import com.tigerspike.flickr.model.bo.Item;
import com.tigerspike.flickr.utils.DefaultValues;

import java.util.List;

/**
 * Class ImageListAdapter extends ArrayAdapter to create a custom list of Items.
 *
 * @author Raul RS
 * @version 1.0
 */
public class ImageListAdapter extends ArrayAdapter {

    // Log
    private final String DEV = "RRS";
    private final String TAG = DEV + ":" + this.getClass().getSimpleName();

    /**
     * Class constructor. Receives the following parameters:
     *
     * @param context - {@link Activity}
     * @param items   - {@link List<Item>}
     */
    public ImageListAdapter(Activity context, List<Item> items) {
        super(context, 0, items);
    }

    /**
     * Provides a View for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    - The position in the list of data that should be displayed in the
     *                    list item View.
     * @param convertView - The recycled View to populate.
     * @param parent      - The parent ViewGroup that is used for inflation.
     * @return View - The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing View is being reused, otherwise inflate the View
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.image_list_item, parent, false);
        }

//        Retrieve item (custom object)
        Item item = (Item) getItem(position);

//        Referencing and setting widgets
        Log.v(TAG, "Attempting to load: " + item.getMedia().getM());
        ImageView thumbnail = (ImageView) listItemView.findViewById(R.id.thumbnail);
        Picasso.with(this.getContext())
                .load(item.getMedia().getM())
                .placeholder(R.drawable.thumbnail_placeholder)
                .error(R.drawable.thumbnail_error)
                .resize(DefaultValues.THUMBNAIL_DEFAULT_SIZE,
                        DefaultValues.THUMBNAIL_DEFAULT_SIZE)
                .centerCrop()
                .into(thumbnail);

        TextView description = (TextView) listItemView.findViewById(R.id.description);
        description.setText(item.getDescription());

        TextView title = (TextView) listItemView.findViewById(R.id.title);
        title.setText(item.getTitle());

        return listItemView;
    }
}

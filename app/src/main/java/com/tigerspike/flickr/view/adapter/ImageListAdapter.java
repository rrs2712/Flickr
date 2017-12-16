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

import java.util.List;

/**
 * Created by rrs27 on 2017-12-16.
 */

public class ImageListAdapter extends ArrayAdapter {

    // Async image loader
//    private ImageLoader imageloader = ImageLoader.getInstance();

    /**
     * Class constructor.
     *
     * @param context - {@link Activity}
     * @param items   - {@link List<Item>}
     */
    public ImageListAdapter(Activity context, List<Item> items) {
        super(context, 0, items);
//        imageloader.init(ImageLoaderConfiguration.createDefault(context));
    }

    /**
     * Provides a View for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item View.
     * @param convertView The recycled View to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if the existing View is being reused, otherwise inflate the View
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.image_list_item, parent, false);
        }

        Item item = (Item) getItem(position);

        ImageView thumbnail = (ImageView) listItemView.findViewById(R.id.thumbnail);
        String url = item.getMedia().getM();

        Log.d("RRS", "Attempt to download: " + url);
//        ContextCompat.getColor(getContext(),newColor);
//        this.getContext().getString(R.dimen.thumbnail_default_size);
        int thumbnail_default_size = (int) this.getContext().getResources().getDimension(R.dimen.thumbnail_default_size);
        thumbnail_default_size = (thumbnail_default_size >=0 ) ? thumbnail_default_size : 100;
        Picasso.with(this.getContext())
                .load(url)
                .placeholder(R.drawable.thumbnail_placeholder)
                .error(R.drawable.thumbnail_error)
                .resize(thumbnail_default_size, thumbnail_default_size)
                .centerCrop()
                .into(thumbnail);
        // Todo: include unit test for image resources

        TextView description = (TextView) listItemView.findViewById(R.id.description);
        String sDescription = (item.getDateTaken().trim() != "") ? item.getDateTaken().trim() : "No description available";
        description.setText(sDescription);

        TextView title = (TextView) listItemView.findViewById(R.id.title);
        String sTitle = (item.getTitle().trim() != "") ? item.getTitle().trim() : "No title available";
        title.setText(item.getTitle());

        return listItemView;
    }

}

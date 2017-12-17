package com.tigerspike.flickr.view.main;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.tigerspike.flickr.R;
import com.tigerspike.flickr.model.bo.Flickr;
import com.tigerspike.flickr.model.bo.Item;
import com.tigerspike.flickr.presenter.MVP;
import com.tigerspike.flickr.presenter.Presenter;
import com.tigerspike.flickr.utils.DefaultValues;
import com.tigerspike.flickr.utils.Tools;
import com.tigerspike.flickr.view.adapter.ImageListAdapter;

import java.util.List;


/**
 * Class MainActivity extends Activity and implements MVP.View.
 *
 * MainActivity has no logic at all, just calls the presenter to ask for data to fill a custom
 * ListView.
 *
 * @author Raul RS
 * @version 1.0
 */
public class MainActivity extends Activity implements MVP.View {

    // Log
    private final String DEV = "RRS";
    private final String TAG = DEV + ":" + this.getClass().getSimpleName();
    // MVP
    private MVP.Presenter presenter;
    // Widgets
    ListView lv;

//    ## ACTIVITY LIFE CYCLE ##

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.image_list);

//        todo: Inject this dependency with Dagger if projects grows
        presenter = new Presenter(this);
        presenter.requestFlickrModel();
    }

//    ## IMPLEMENTATIONS ##

    /**
     * The presenter will call this method once it has the data requested by MainActivity
     *
     * @param flickr
     */
    @Override
    public void onReceive(Flickr flickr) {
        Log.i(TAG, "onReceive");
        setWidgets(flickr.getItems(), this.lv, this);
//        Tools.printFlickrItems(flickr);
    }

    /**
     * The Presenter will call this method when a exception occurs.
     *
     * @param msg
     */
    @Override
    public void onReceive(String msg) {
        Tools.showMessage4User(this, DefaultValues.ERROR_FOUND_MSG, msg);
    }

//    ## CLASS METHODS ##

    /**
     * Method to set a custom ListView for a list of {@link Item}.
     *
     * @param results - {@link List<Item>}
     * @param lv      - {@link ListView}
     * @param context - {@link Activity}
     */
    private void setWidgets(final List<Item> results, ListView lv, Activity context) {
        Log.i(TAG, "setWidgets");
        ImageListAdapter imageListAdapter = new ImageListAdapter(context, results);
        lv.setAdapter(imageListAdapter);
    }

    /**
     * Dependency injection of a MVP.Presenter implementation
     *
     * @param presenter
     */
    public void setPresenter(MVP.Presenter presenter) {
        this.presenter = presenter;
    }

}

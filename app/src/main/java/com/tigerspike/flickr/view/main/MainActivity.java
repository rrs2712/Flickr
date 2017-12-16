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
import com.tigerspike.flickr.view.adapter.ImageListAdapter;

import java.util.List;

public class MainActivity extends Activity  implements MVP.View{

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    // Log
    private final String DEV = "RRS";
    private final String TAG = DEV + ":" + this.getClass().getSimpleName();
    // Bundles
    public static final String ITEM_ID = "item_detail_id";
    // MVP
    private MVP.Presenter presenter;
    // Widgets
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.image_list);
        presenter = new Presenter(this);
        presenter.requestFlickrModel();

//        todo : implement no-internet defaults
    }

//    /**
//     *
//     * Method called when users clicks on an item.
//     *
//     * @param id - String
//     */
//    private void showDetail(String id) {
//        Log.d(TAG,"Selected item: " + id);
//
//        Bundle b = new Bundle();
//        b.putString(ITEM_ID,id);
//
//        Intent i = new Intent(this, DetailView.class);
//        i.putExtras(b);
//        startActivity(i);
//    }

    @Override
    public void onReceive(Flickr flickr) {
        setWidgets(flickr.getItems(), this.lv,this);
//        printFlickr(flickr);
    }

    private void printFlickr(Flickr flickr) {
        for (Item item: flickr.getItems()) {
            Log.d(TAG,item.getTitle());
            Log.d(TAG,item.getLink());
        }
    }

    /**
     *
     * Method to set a custom ListView for a list of comics
     *
     * @param results - {@link List<Item>}
     * @param lv - {@link ListView}
     * @param context - {@link Activity}
     */
    private void setWidgets(final List<Item> results, ListView lv, Activity context) {
        ImageListAdapter imageListAdapter = new ImageListAdapter(context,results);

        lv.setAdapter(imageListAdapter);
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Result comic = results.get(position);
//                Log.d(TAG,"Click on comic: " +  comic.toString());
//                showDetail(comic.getId().toString());
//            }
//        });
    }

}

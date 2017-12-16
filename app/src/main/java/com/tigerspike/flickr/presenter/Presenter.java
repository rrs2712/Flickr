package com.tigerspike.flickr.presenter;

import com.tigerspike.flickr.model.bo.Flickr;
import com.tigerspike.flickr.model.source.MainModel;

/**
 * Created by rrs27 on 2017-12-16.
 */

public class Presenter implements MVP.Presenter {

    // MVP variables
    private MVP.View view;
    private MVP.Model model;

    /**
     * Class constructor.
     *
     * @param view - {@link MVP.View}
     */
    public Presenter(MVP.View view) {
        this.view = view;
        this.model = new MainModel(this);
    }

    // ## Implementations ## //

    @Override
    public void requestFlickrModel() {
        if(this.model!=null){
            this.model.requestFlickrModel();
        }
    }

    @Override
    public void onReceive(Flickr flickr) {
        if(this.view!=null){
            this.view.onReceive(flickr);
        }
    }
}

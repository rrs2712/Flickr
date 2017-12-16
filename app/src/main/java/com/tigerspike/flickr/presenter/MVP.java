package com.tigerspike.flickr.presenter;

import com.tigerspike.flickr.model.bo.Flickr;

/**
 * Created by rrs27 on 2017-12-16.
 */

public interface MVP {
    interface View {
        void onReceive(Flickr flickr);
    }

    interface Presenter{
        void requestFlickrModel();
        void onReceive(Flickr flickr);
    }

    interface Model{
        void requestFlickrModel();
    }
}

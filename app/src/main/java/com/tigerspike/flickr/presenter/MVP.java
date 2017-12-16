package com.tigerspike.flickr.presenter;

import com.tigerspike.flickr.model.bo.Flickr;

/**
 * Interface MVP contains sub-interfaces with custom methods to support the Model(s), View(s) and
 * Presenter(s) corresponding to the MVP model.
 *
 * @author Raul RS
 * @version 1.0
 */public interface MVP {

    /**
     * Interface with methods needed for the View implementations
     */
    interface View {
        void onReceive(Flickr flickr);
    }

    /**
     * Interface with methods needed for the Presenter implementations
     */
    interface Presenter{
        void requestFlickrModel();
        void onReceive(Flickr flickr);
    }

    /**
     * Interface with methods needed for the Model implementations
     */
    interface Model{
        void requestFlickrModel();
    }
}

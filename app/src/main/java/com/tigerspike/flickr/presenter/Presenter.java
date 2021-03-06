package com.tigerspike.flickr.presenter;

import com.tigerspike.flickr.model.bo.Flickr;
import com.tigerspike.flickr.model.source.MainModel;

/**
 * Class Presenter implements MVP.Presenter.
 *
 * Presenter is the "bridge" between the View and the Model (In this case between
 * {@link com.tigerspike.flickr.view.main.MainActivity} and {@link MainModel}).
 * It helps to isolate both, the Android framework from the model and vice versa.
 *
 * @author Raul RS
 * @version 1.0
 */
public class Presenter implements MVP.Presenter {

    // MVP variables
    private MVP.View view;
    private MVP.Model model;

    /**
     * Class constructor. This class will receive an implementation of {@link MVP.View}. Likewise,
     * this class will use an implementation of {@link MVP.Model}.
     *
     * @param view - {@link MVP.View}
     */
    public Presenter(MVP.View view) {
        this.view = view;
//        todo: Inject this dependency with Dagger if projects grows
        this.model = new MainModel(this);
    }

    // ## IMPLEMENTATIONS ## //

    /**
     * This method will request the data to the model, and will be used by the View.
     */
    @Override
    public void requestFlickrModel() {
        if (this.model != null) {
            this.model.requestFlickrModel();
        }
    }

    /**
     * This method is called by the model, and will send the {@link Flickr} to the View.
     *
     * @param flickr - object with data
     */
    @Override
    public void onReceive(Flickr flickr) {
        if (this.view != null) {
            this.view.onReceive(flickr);
        }
    }

    /**
     * This method is called by the model, and will send a message to the view in case of an
     * exception occurs
     *
     * @param msg
     */
    @Override
    public void onReceive(String msg) {
        if (this.view != null) {
            this.view.onReceive(msg);
        }
    }

//    ## CLASS METHODS ##

}

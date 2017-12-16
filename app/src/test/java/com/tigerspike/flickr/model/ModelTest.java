package com.tigerspike.flickr.model;

import com.tigerspike.flickr.model.bo.Flickr;
import com.tigerspike.flickr.model.source.MainModel;
import com.tigerspike.flickr.presenter.MVP;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by rrs27 on 2017-12-16.
 */

public class ModelTest {

    @Test
    public void testModel() {
        MVP.Presenter presenter = new MVP.Presenter() {
            @Override
            public void requestFlickrModel() {
            }

            @Override
            public void onReceive(Flickr flickr) {
            }
        };

        MainModel mainModel = new MainModel(presenter);

        assertTrue(
                "Model must implement MVP.Model to preserve MVP model",
                mainModel instanceof MVP.Model);
    }
}

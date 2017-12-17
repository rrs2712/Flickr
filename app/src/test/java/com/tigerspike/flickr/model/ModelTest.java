package com.tigerspike.flickr.model;

import com.tigerspike.flickr.model.bo.Flickr;
import com.tigerspike.flickr.model.source.MainModel;
import com.tigerspike.flickr.presenter.MVP;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * This class will check the models used in this project.
 *
 * @author Raul RS
 * @version 1.0
 */
public class ModelTest {

    /**
     * This method checks if the model is an implementation of MVP.Model.
     */
    @Test
    public void testModel() {
        MVP.Presenter presenter = new MVP.Presenter() {
            @Override
            public void requestFlickrModel() {
            }

            @Override
            public void onReceive(Flickr flickr) {
            }

            @Override
            public void onReceive(String msg) {

            }
        };

        MainModel mainModel = new MainModel(presenter);

        assertTrue(
                "Model must implement MVP.Model to preserve MVP model",
                mainModel instanceof MVP.Model);
    }
}

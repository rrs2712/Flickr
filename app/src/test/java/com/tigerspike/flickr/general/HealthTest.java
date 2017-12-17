package com.tigerspike.flickr.general;

import com.tigerspike.flickr.model.bo.Flickr;
import com.tigerspike.flickr.presenter.MVP;
import com.tigerspike.flickr.presenter.Presenter;

import org.junit.Test;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * This class will check important approaches of classes and methods to cover minimal requirements
 * of this app. This class will help to cover Test-Driven Development for no
 * Android-instrumented tests.
 *
 * @author Raul RS
 * @version 1.0
 */
public class HealthTest {


    /**
     * This method checks that {@link com.tigerspike.flickr.model.source.MainModel MainModel} will return
     * something to the presenter. This could be either way, a {@link com.tigerspike.flickr.model.bo.Flickr Flickr}
     * or an error message;
     */
    @Test
    public void testMainModelAnswer() {

        MVP.View view = new MVP.View() {
            Presenter presenter = new Presenter(this);

            @Override
            public void onReceive(Flickr flickr) {
                assertNotNull(
                        "Flickr is returned as null",
                        flickr);
            }

            @Override
            public void onReceive(String msg) {
                assertNotEquals(
                        "Empty message received",
                        "",
                        msg);
            }
        };

    }

}

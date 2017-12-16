package com.tigerspike.flickr.presenter;

import com.tigerspike.flickr.model.bo.Flickr;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by rrs27 on 2017-12-16.
 */

public class PresenterTest {

    @Test
    public void testPresenter() {
        MVP.View view = new MVP.View() {
            @Override
            public void onReceive(Flickr flickr) {
            }
        };

        Presenter presenter = new Presenter(view);
        assertTrue(
                "Presenter should implement MVP.Presenter to preserve MVP model",
                presenter instanceof MVP.Presenter);
    }
}

package com.tigerspike.flickr.presenter;

import com.tigerspike.flickr.model.bo.Flickr;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * This class will check the Presenter used in this project.
 *
 * @author Raul RS
 * @version 1.0
 */
public class PresenterTest {

    /**
     * This method checks if the presenter is an implementation of MVP.Presenter.
     */
    @Test
    public void testPresenter() {
        MVP.View view = new MVP.View() {
            @Override
            public void onReceive(Flickr flickr) {
            }

            @Override
            public void onReceive(String msg) {

            }
        };

        Presenter presenter = new Presenter(view);
        assertTrue(
                "Presenter should implement MVP.Presenter to preserve MVP model",
                presenter instanceof MVP.Presenter);
    }
}

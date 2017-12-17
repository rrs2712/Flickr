package com.tigerspike.flickr.view;

import com.tigerspike.flickr.presenter.MVP;
import com.tigerspike.flickr.view.main.MainActivity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * This class will check the Views used in this project.
 *
 * @author Raul RS
 * @version 1.0
 */
public class ViewTest {

    /**
     * This method checks if the main activity is an implementation of MVP.View.
     */
    @Test
    public void testMainView() {
        MainActivity mainActivity = new MainActivity();
        assertTrue(
                "Activities (Views) must implement MVP.View to preserve MVP model",
                mainActivity instanceof MVP.View);
    }
}

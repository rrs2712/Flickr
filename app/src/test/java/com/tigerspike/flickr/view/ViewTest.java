package com.tigerspike.flickr.view;

import com.tigerspike.flickr.presenter.MVP;
import com.tigerspike.flickr.view.main.MainActivity;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by rrs27 on 2017-12-16.
 */

public class ViewTest {

    @Test
    public void testMainView() {
        MainActivity mainActivity = new MainActivity();
        assertTrue(
                "Activities (Views) must implement MVP.View to preserve MVP model",
                mainActivity instanceof MVP.View);
    }
}

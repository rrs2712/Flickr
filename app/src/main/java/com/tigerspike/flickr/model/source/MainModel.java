package com.tigerspike.flickr.model.source;

import android.util.Log;

import com.tigerspike.flickr.model.bo.Flickr;
import com.tigerspike.flickr.presenter.MVP;
import com.tigerspike.flickr.utils.Tools;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class MainModel implements MVP.Model and uses {@link Retrofit} to retrieve data from Flickr
 * using its API. Afterwards, this class will send such data
 * to the {@link com.tigerspike.flickr.presenter.MVP.Presenter}
 *
 * @author Raul RS
 * @version 1.0
 */
public class MainModel implements MVP.Model {

    // Log
    private final String DEV = "RRS";
    private final String TAG = DEV + ":" + this.getClass().getSimpleName();
    // Presenter
    private MVP.Presenter presenter;

    /**
     * Class constructor. Receives {@link MVP.Presenter} to instantiate this class.
     *
     * @param presenter - MVP.Presenter
     */
    public MainModel(MVP.Presenter presenter) {
        Log.d(TAG, "Using presenter implementation: " + presenter.getClass().getSimpleName());
        this.presenter = presenter;
    }

//    ## IMPLEMENTATIONS ##

    /**
     * Method called by the presenter to request data to this model.
     */
    @Override
    public void requestFlickrModel() {
        retrieveData();
    }

    /**
     * Obtains data async from an end point using {@link Retrofit}. In addition, once the data
     * is retrieved will send such data to the presenter.
     */
    private void retrieveData() {
        Log.i(TAG, "retrieveData");

//        Create retrofit instance
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FlickrContract.END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

//        Request and transforms data async
        FlickrContract flickrContract = retrofit.create(FlickrContract.class);
        Call<Flickr> flickrCall = flickrContract.getFlickr(
                FlickrContract.RESPONSE_JSON,
                FlickrContract.NO_JSON_CALLBACK);

//        Handling callback
        flickrCall.enqueue(new Callback<Flickr>() {
            @Override
            public void onResponse(Call<Flickr> call, Response<Flickr> response) {
                if (!response.isSuccessful()) {
                    Tools.printUnsuccessfulResponse(call,response);
                    return;
                }

                Log.i(TAG, "onResponse: " + response.toString());
                Flickr flickr = response.body();
//                Tools.printFlickrItems(flickr);
                presenter.onReceive(flickr);
            }

            @Override
            public void onFailure(Call<Flickr> call, Throwable t) {
                Tools.printOnFailure(call,t);
//                todo: Handle this error
            }
        });
    }

}

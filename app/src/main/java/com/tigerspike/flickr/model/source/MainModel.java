package com.tigerspike.flickr.model.source;

import android.util.Log;

import com.tigerspike.flickr.model.bo.Flickr;
import com.tigerspike.flickr.model.bo.Item;
import com.tigerspike.flickr.presenter.MVP;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by rrs27 on 2017-12-16.
 */

public class MainModel implements MVP.Model {

    // Log
    private final String DEV = "RRS";
    private final String TAG = DEV + ":" + this.getClass().getSimpleName();
    // Presenter
    private MVP.Presenter presenter;

    /**
     * Class constructor. Receives {@link MVP.Presenter} to instantiate this class.
     * @param mainPresenter - IComic.Presenter
     */
    public MainModel(MVP.Presenter mainPresenter) {
        Log.d(TAG, "Using " + this.getClass().getSimpleName());
        this.presenter = mainPresenter;
    }

    @Override
    public void requestFlickrModel() {
        retrieveData();
    }

    /**
     * Obtains data from an end point using {@link Retrofit}
     *
     */
    private void retrieveData() {
        Log.d(TAG,"retrieveData");

//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(FlickrContract.END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
//                .addConverterFactory(SimpleXmlConverterFactory.create())
                .build();

        FlickrContract flickrContract = retrofit.create(FlickrContract.class);
        Call<Flickr> flickrCall = flickrContract.getFlickr(
                FlickrContract.RESPONSE_JSON,
                FlickrContract.NO_JSON_CALLBACK);

        flickrCall.enqueue(new Callback<Flickr>() {
            @Override
            public void onResponse(Call<Flickr> call, Response<Flickr> response) {
                if(!response.isSuccessful()){
                    Log.w(TAG,"unsuccessful: " + response.code());
                    Log.i(TAG,call.request().toString());
                    Log.i(TAG,call.request().headers().toString());
                    Log.i(TAG,response.toString());

                    return;
                }

                Log.i(TAG,"onResponse: "+ response.toString());
//                Log.i(TAG,"BODY: "+ response.body().getFeed().toString());
//                str = str.substring("jsonFlickrFeed(".length(), str.length()-1);
                Flickr flickr = response.body();
//                printFlickr(flickr);
                presenter.onReceive(flickr);
            }

            @Override
            public void onFailure(Call<Flickr> call, Throwable t) {
                Log.e(TAG,"onFailure: " + t.getMessage());
                Log.i(TAG,call.request().toString());
                Log.i(TAG,call.request().headers().toString());
            }
        });
    }

    private void printFlickr(Flickr flickr) {
        for (Item item: flickr.getItems()) {
            Log.d(TAG,item.getTitle());
            Log.d(TAG,item.getLink().toString());
        }
    }
}

package com.tigerspike.flickr.utils;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.tigerspike.flickr.R;
import com.tigerspike.flickr.model.bo.Flickr;
import com.tigerspike.flickr.model.bo.Item;

import retrofit2.Call;
import retrofit2.Response;

/**
 *
 * Class Tools provide a number of static methods meant to help other classes in this project.
 *
 * @author Raul RS
 * @version 1.0
 */
public class Tools{

    // Log
    private final static String DEV = "RRS";
    private final static String TAG = DEV + ":" + Tools.class.getSimpleName();

    /**
     * This method retrieves the default value for thumbnails contained in values/dimens.xml
     * If a default value is not found, then this method will ensure a default value and return it.
     *
     * @param context - Activity
     * @return thumbnail default size - int
     */
    public static int getThumbnailDefaultSize(Activity context){
        int thumbnail_default_size = DefaultValues.THUMBNAIL_DEFAULT_SIZE;

        try {
            thumbnail_default_size = (int) context.getResources().getDimension(R.dimen.thumbnail_default_size);
        } catch (Resources.NotFoundException e) {
            Log.w(TAG, e.getMessage());
        }

        return thumbnail_default_size;
    }

    /**
     * Prints the content of the items contained into a {@link Flickr}
     * @param flickr
     */
    public static void printFlickrItems(Flickr flickr) {
        for (Item item: flickr.getItems()) {
            Log.d(TAG,item.getTitle());
            Log.d(TAG,item.getLink());
        }
    }

    /**
     * Prints important info contained in the given params. In addition, will return a simple
     * cause to send to the view and eventually display to the user.
     *
     * @param call
     * @param response
     * @return cause - String
     */
    public static String getUnsuccessfulResponse(Call<Flickr> call, Response<Flickr> response) {
        String msg = "Connection established with unsuccessful response. Code: " + response.code();
        Log.w(TAG, msg);
        Log.v(TAG, call.request().toString());
        Log.v(TAG, call.request().headers().toString());
        Log.v(TAG, response.toString());
        return msg;
    }

    /**
     * Print on log important info related to the cause of a failure. Method meant to
     * debug easier.
     *
     * @param call
     * @param t
     */
    public static void printOnFailure(Call<Flickr> call, Throwable t) {
        Log.e(TAG, "onFailure: " + t.getMessage());
        Log.i(TAG, call.request().toString());
        Log.i(TAG, call.request().headers().toString());
    }

    /**
     * Shows a simple and generic AlertDialog. Use this method to display info to the user that
     * should not disappear immediately (i.e. not like a Toast).
     *
     * @param context
     * @param title
     * @param message
     */
    public static void showMessage4User(Context context, String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}

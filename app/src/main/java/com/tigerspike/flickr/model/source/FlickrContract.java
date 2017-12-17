package com.tigerspike.flickr.model.source;

import com.tigerspike.flickr.model.bo.Flickr;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Interface FlickrContract contains static variables (i.e. end point) and methods to implement
 * when using the Flickr API
 * @see <a href="https://www.flickr.com/services/feeds/docs/photos_public">Flickr API</a>
 *
 * @author Raul RS
 * @version 1.0
 */
public interface FlickrContract {
    public static final String END_POINT="https://api.flickr.com/";
    public static final String RESPONSE_JSON = "json";
    public static final String NO_JSON_CALLBACK = "1"; // https://www.flickr.com/services/api/response.json.html

    @GET("services/feeds/photos_public.gne")
    Call<Flickr> getFlickr(
            @Query("format") String responseFormat,
            @Query("nojsoncallback") String nojsoncallback);

//    todo: implement more methods if necessary
}

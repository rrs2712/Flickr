package com.tigerspike.flickr.model.source;

import com.tigerspike.flickr.model.bo.Flickr;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by rrs27 on 2017-12-16.
 */

public interface FlickrContract {
    public static final String END_POINT="https://api.flickr.com/";
    public static final String RESPONSE_JSON = "json";
    public static final String NO_JSON_CALLBACK = "1"; // https://www.flickr.com/services/api/response.json.html

    @GET("services/feeds/photos_public.gne")
    Call<Flickr> getFlickr(
            @Query("format") String responseFormat,
            @Query("nojsoncallback") String nojsoncallback);

//    @GET("services/feeds/photos_public.gne")
//    Call<String> getFlickr(@Query("format") String responseFormat);

//    @Headers("Accept: */*")
//    @GET("v1/public/comics")
//    Call<Marvel> getMarvelComics(
//            @Query("ts") String timeStamp,
//            @Query("apikey") String publicKey,
//            @Query("hash") String hash,
//            @Query("limit") int limit);
//
//    @Headers("Accept: */*")
//    @GET("v1/public/comics/{comicId}")
//    Call<Marvel> getComic(
//            @Path("comicId") String comicId,
//            @Query("ts") String timeStamp,
//            @Query("apikey") String publicKey,
//            @Query("hash") String hash);

}

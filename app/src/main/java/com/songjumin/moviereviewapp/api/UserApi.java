package com.songjumin.moviereviewapp.api;

import com.songjumin.moviereviewapp.model.UserReq;
import com.songjumin.moviereviewapp.model.UserRes;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UserApi {

    @POST("/api/v1/users")
    Call<UserRes> createUser(@Body UserReq userReq);

    @POST("/api/v1/users/login")
    Call<UserRes> loginUser(@Body UserReq userReq);

    @DELETE("/api/v1/users/logout")
    Call<UserRes> logoutUser(@Header("Authorization") String token);

}

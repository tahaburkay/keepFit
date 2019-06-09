package com.example.tabuto.keepfit.Utils;

import com.example.tabuto.keepfit.model.Nutrition;
import com.example.tabuto.keepfit.model.User.User;
import com.example.tabuto.keepfit.model.Workout;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KeepFitApi {


    @GET("/users")
    Call<List<User>> getUsers();

    @GET("/workouts/type/Zayif")
    Call<List<Workout>> getWorkout();

    @GET("/nutritions/type/Zayif")
    Call<List<Nutrition>> getNutrition();

}

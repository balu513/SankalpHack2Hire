package com.example.hack2hire.retrofit;



import com.example.hack2hire.model.Goal;
import com.example.hack2hire.model.Transaction;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ShankalpApi {


    @GET("contacts.json")
    Call<List<Transaction>> getAllTransactions();

    @GET("goals.json")
    Call<List<Goal>> getAllGoals();
}

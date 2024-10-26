package com.example.retrofitcalismasi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeDAOInterface {
    @GET("employees")
    Call<EmployeesCevap> allEmployees();





}

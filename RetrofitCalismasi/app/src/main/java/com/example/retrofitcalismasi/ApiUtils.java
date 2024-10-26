package com.example.retrofitcalismasi;

public class ApiUtils {
    public static final String BASE_URL = "http://10.0.2.2:8080/";

    public static EmployeeDAOInterface getEmployeeDAOInterface(){
        return RetrofitClient.getClient(BASE_URL).create(EmployeeDAOInterface.class);
    }


}

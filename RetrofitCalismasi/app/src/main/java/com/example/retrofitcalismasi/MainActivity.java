package com.example.retrofitcalismasi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private EmployeeDAOInterface employeeDIF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeDIF =  ApiUtils.getEmployeeDAOInterface();

        allEmployees();
    }


    public void allEmployees(){
        employeeDIF.allEmployees().enqueue(new Callback<EmployeesCevap>() {
            @Override
            public void onResponse(Call<EmployeesCevap> call, Response<EmployeesCevap> response) {

                List<EmployeesCevap> employeesCevaps = (List<EmployeesCevap>) response.body();
                for(EmployeesCevap k : employeesCevaps){
                    Log.e("*******", "*******");
                    Log.e("Employee Firstname",k.getFirstName());
                }

                /*for(String k: employeesFirstNames){
                    Log.e("*******","*******" );
                    Log.e("Employee Firstname", k);
                }*/

            }

            @Override
            public void onFailure(Call<EmployeesCevap> call, Throwable t) {
                Log.d("snow", t.getMessage().toString());
            }
        });
    }
}
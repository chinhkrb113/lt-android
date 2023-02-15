package com.example.homeworkinternetjson;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homeworkinternetjson.api.model.APIService;
import com.example.homeworkinternetjson.api.model.DataFromAPIItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    InforAdapter adapter;
    private List<DataFromAPIItem> listData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        APIService.apiService.getDataFromAPI().enqueue(new Callback<List<DataFromAPIItem>>() {
            @Override
            public void onResponse(Call<List<DataFromAPIItem>> call, Response<List<DataFromAPIItem>> response) {
                 listData=response.body();
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         //set data for recycleview. Data là listdata
                         adapter=new InforAdapter(MainActivity.this,listData);
                         recyclerView.setAdapter(adapter);
                         registerForContextMenu(recyclerView);

                     }
                 });
            }

            @Override
            public void onFailure(Call<List<DataFromAPIItem>> call, Throwable t) {
                Log.e("viet-error", t.getMessage());
            }
        });

    }


}
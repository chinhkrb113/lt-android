package com.example.contactlist;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.bloco.faker.Faker;


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ContactModel> arrayList=new ArrayList<ContactModel>();
    MainAdapter adapter;
    Faker faker =new Faker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recylerView);
        createFakeData();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MainAdapter(this,arrayList);
        recyclerView.setAdapter(adapter);
        registerForContextMenu(recyclerView);


    }

    public void createFakeData(){
        for(int i=0;i<40;i++){
            ContactModel model=new ContactModel();
            model.setName(faker.name.name());
            model.setEmail(faker.internet.email());
            model.setTel(faker.phoneNumber.cellPhone());
            Log.e("vietbeo",model.getTel());
            arrayList.add(model);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        ContactModel model= arrayList.get(adapter.getPosition());
        Uri uri=Uri.parse("tel:"+model.tel);
        Uri mail=Uri.parse("send to:"+model.email);

        switch (item.getItemId()){
            case 121:
                String phone = model.getTel();
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                startActivity(intent);
            case 122:
                Uri n=Uri.parse("tel:"+model.tel);
                Intent sms=new Intent(Intent.ACTION_VIEW, Uri.parse("sms to:"+model.tel));
                startActivity(sms);
            case 123:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO,mail);
                startActivity(emailIntent);


        }
        return super.onContextItemSelected(item);
    }
}
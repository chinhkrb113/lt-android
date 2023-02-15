package com.example.homeworkinternetjson;



import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.homeworkinternetjson.api.model.DataFromAPIItem;

import java.util.ArrayList;
import java.util.List;

public class InforAdapter extends RecyclerView.Adapter<InforAdapter.ViewHolder> implements View.OnClickListener {
    List<DataFromAPIItem> arrayList;
    Context context;



    public InforAdapter(Context context, List<DataFromAPIItem> arrayList){
        this.context=context;
        this.arrayList=arrayList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info,parent,false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,@SuppressLint("RecyclerView") int position) {
        DataFromAPIItem inforList= (DataFromAPIItem) arrayList.get(position);
        holder.tvPhone.setText(inforList.getPhone());
        holder.tvEmail.setText(inforList.getEmail());
        holder.tvName.setText(inforList.getName());
        String url="https://lebavui.github.io"+inforList.getAvatar().getPhoto();
        Glide.with(context).load(url).into(holder.ivAvatar);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(context,specificInfo.class);
                Intent n= new Intent(context,specificInfo.class);
                intent.putExtra("Name",inforList.getName());
                intent.putExtra("Tel",inforList.getPhone());
                intent.putExtra("Email",inforList.getEmail());
                intent.putExtra("Url",inforList.getAvatar().getPhoto());
                intent.putExtra("UserName",inforList.getUsername());
                intent.putExtra("Street",inforList.getAddress().getStreet());
                intent.putExtra("City",inforList.getAddress().getCity());
                context.startActivity(n);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick(View view) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName,tvEmail,tvPhone;
        ImageView ivAvatar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.name);
            tvEmail=itemView.findViewById(R.id.email);
            tvPhone=itemView.findViewById(R.id.phone);
            ivAvatar=itemView.findViewById(R.id.avatar);
        }
    }

}

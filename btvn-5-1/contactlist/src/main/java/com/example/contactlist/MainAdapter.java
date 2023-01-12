package com.example.contactlist;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    Activity activity;
    ArrayList<ContactModel> arrayList;
    private int position;
    Context context;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }


    public MainAdapter(Activity activity,ArrayList<ContactModel> arrayList){
         this.activity=activity;
         this.arrayList=arrayList;
         notifyDataSetChanged();


     }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context= parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
         ContactModel model= arrayList.get(position);
         holder.tvName.setText(model.getName());
         holder.tvFirstLetterName.setText(String.format("%s", model.getFirstLetter()));
         holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                setPosition(position);
                return false;
            }

        });
         holder.itemView.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent intent=new Intent(context,specificInfo.class);
                 Intent n= new Intent(context,specificInfo.class);
                 intent.putExtra("Name",model.getName());
                 intent.putExtra("Tel",model.getTel());
                 intent.putExtra("Email",model.getEmail());
                 context.startActivity(n);
                 context.startActivity(intent);
             }
         });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener {
        public ImageView icon;

        public TextView fileName;
        public LinearLayout cardView;
        TextView tvName,tvFirstLetterName;

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v,
                                        ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select an option");
            //menuInfo is null
            menu.add(this.getAdapterPosition(), 121,0,"Call");
            menu.add(this.getAdapterPosition(),122,1,"Send SMS");
            menu.add(this.getAdapterPosition(),123,2,"Send Email");
        }


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName=itemView.findViewById(R.id.name);
            tvFirstLetterName=itemView.findViewById(R.id.roundTextView);
            cardView=itemView.findViewById(R.id.cardView);
            cardView.setOnCreateContextMenuListener(this);

        }
    }



}

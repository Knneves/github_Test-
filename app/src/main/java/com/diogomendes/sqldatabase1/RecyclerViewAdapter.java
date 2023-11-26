package com.diogomendes.sqldatabase1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<Card> cards;
    public RecyclerViewAdapter(Context context, ArrayList<Card> cards, RecyclerViewInterface recyclerViewInterface) {
        this.context = context;
        this.cards = cards;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the layout (Giving a look to our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return new RecyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.MyViewHolder holder, int position) {
        // assigning values to the views we created in the recycler_view_row layout file
        // based on the position of the recycler view

        holder.txtName.setText(cards.get(position).getName());
        holder.txtJob.setText(cards.get(position).getJob());
        holder.imgView.setImageResource(cards.get(position).getImg());

        /*
        holder.btnViewCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click here
                // You can use 'position' to get the corresponding item from the 'cards' list
                //Card clickedCard = cards.get(position);
                // Perform any actions you want based on the clicked card
                // For example, you can open a new activity or show a dialog
                // You can use 'context' to start a new activity or show a dialog
                // Example: context.startActivity(new Intent(context, YourActivity.class));

                Intent intent = new Intent(context, ProfileActivity.class);
                context.startActivity(intent);
            }
        });

         */
    }

    @Override
    public int getItemCount() {
        // the recycler view just wants to know the number of items you want displayed
        return cards.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        // grabbing the views from our recycler_view_row layout file
        // Kinda like in the onCreate method

        TextView txtName, txtJob;
        ImageView imgView;
        Button btnViewCard;

        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtViewName);
            txtJob = itemView.findViewById(R.id.txtViewJob);
            imgView = itemView.findViewById(R.id.imgProfile);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();

                        if(pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });

        }


    }
}

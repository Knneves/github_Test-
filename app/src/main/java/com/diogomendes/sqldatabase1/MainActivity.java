package com.diogomendes.sqldatabase1;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    // creating variables for our edittext, button and dbhandler
    DBHandler dbHandler;
    SQLiteDatabase db;
    ArrayList<Card> cards = new ArrayList<Card>();

    int[] profileImg = {R.drawable.gru, R.drawable.kevin, R.drawable.stuart, R.drawable.bob, R.drawable.nefario, R.drawable.doofen};
    Card card;

    TextView txtpeta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.cardsList);
        //btnView = findViewById(R.id.btnViewCard);

        dbHandler = new DBHandler(MainActivity.this);
        db = dbHandler.getReadableDatabase();

        storeDataInArray();



        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, cards, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    void storeDataInArray (){
        Cursor cursor = dbHandler.readAllData();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }else{
            int i = 0;
            while(cursor.moveToNext()){
                cards.add(new Card(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5),
                        cursor.getString(6),
                        profileImg[i]
                ));
                //cards.add(card);
                /*
                cards.add(card);
                cards.get(i).setId(cursor.getString(0));
                cards.get(i).setName(cursor.getString(1));
                cards.get(i).setEmail(cursor.getString(2));
                cards.get(i).setJob(cursor.getString(3));
                cards.get(i).setPhoneNumber(cursor.getString(4));

                 */
                i++;
                //txtpeta.setText(i);


            }
        }
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(MainActivity.this, ProfileActivity.class);

        intent.putExtra("NAME", cards.get(position).getName());
        intent.putExtra("EMAIL", cards.get(position).getEmail());
        intent.putExtra("PHONE", cards.get(position).getPhoneNumber());
        intent.putExtra("IMAGE", cards.get(position).getImg());
        intent.putExtra("LINKEDIN", cards.get(position).getLinkedin());
        intent.putExtra("JOB", cards.get(position).getJob());
        intent.putExtra("DEGREE", cards.get(position).getDegree());

        startActivity(intent);

    }
}

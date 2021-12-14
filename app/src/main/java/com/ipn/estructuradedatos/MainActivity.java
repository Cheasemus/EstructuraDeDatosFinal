package com.ipn.estructuradedatos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewHolder.OnClick
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerLocations);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerViewHolder(getLayoutInflater(), LocationsList.initLocationsData(this), this));
    }

    public void goToPlay(View view)
    {
        startActivity(new Intent(MainActivity.this, IntroActivity.class));
    }

    @Override
    public void click(LocationData locationData) {
        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        intent.putExtra("name", locationData.getName());
        intent.putExtra("address", locationData.getAddress());
        intent.putExtra("description",locationData.getDescription());
        intent.putExtra("image", locationData.getImageV());
        startActivity(intent);
    }
}
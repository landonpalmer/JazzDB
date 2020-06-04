package com.example.jazzdb;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FAB functionality - add player info to DB
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stepIntoAddActivity();
            }
        });

        // Current DB button functionality - see live DB
        Button button_seeCurrentDB = (Button) findViewById(R.id.button_seeCurrentDB);
        button_seeCurrentDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stepIntoViewCurrentDBActivity();
                Log.d("null", "hello world");
            }
        });
    }

    // Go into add activity method
    public void stepIntoAddActivity() {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    // Go into add activity method
    public void stepIntoViewCurrentDBActivity() {
        Intent intent = new Intent(this, ViewCurrentDB.class);
        startActivity(intent);
    }

}



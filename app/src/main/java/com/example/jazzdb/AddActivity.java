package com.example.jazzdb;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.jazzdb.db.JazzesTable;


public class AddActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Instantiating objects (see XML)
        final EditText editText_name = (EditText) findViewById(R.id.editText_jName);
        final EditText editText_number = (EditText) findViewById(R.id.editText_jNumber);
        Button button_save = (Button) findViewById(R.id.button_save);

        // Magic happens after info typed in, save button pressed
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jname = editText_name.getText().toString();
                String jnumber = editText_number.getText().toString();

                // Open up pre-formatted DB and insert records from plainTexts for player name and number
                JazzesTable jazzesTable = new JazzesTable(getApplicationContext());
                jazzesTable.openDB();
                jazzesTable.insertRecord(jname, jnumber);

                // If mission success
                Toast.makeText(getApplicationContext(), "saved!", Toast.LENGTH_SHORT).show();
                jazzesTable.closeDB();

                // go back to previous activity
                finish();
            }
        });
    }
}


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_add);
//
//        final EditText editText_name = (EditText) findViewById(R.id.editText_jname);
//        final EditText editText_number = (EditText) findViewById(R.id.editText_jnumber);
//        button = (Button) findViewById(R.id.button_save);
//
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String jname = editText_name.getText().toString();
//                String jnumber = editText_number.getText().toString();
//
//
//                JazzesTable jazzesTable = new JazzesTable(getApplicationContext());
//                jazzesTable.openDB();
//                jazzesTable.insertRecord(jname, jnumber);
//                Toast.makeText(getApplicationContext(), "saved", Toast.LENGTH_SHORT).show();
//                jazzesTable.closeDB();
//
//                finish();
//
//
//            }
//        });
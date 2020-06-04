package com.example.jazzdb;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.example.jazzdb.db.JazzesTable;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;

public class ViewCurrentDB extends AppCompatActivity {

    JazzesTable jazzesTable;
    Cursor cursor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_current_db);

        jazzesTable = new JazzesTable(getApplicationContext());
        jazzesTable.openDB();
        cursor = jazzesTable.getAllRecords();

        // ListView holds components from DB in a 2 by 3 format
        ListView listView = (ListView) findViewById(R.id.listView_currentDB);

        // ListView set to a CustomAdapter that inflates a custom layout operated by Cursor
        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return cursor.getCount();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            // inflater allows to access individual XML elements in an organized fashion
            view = getLayoutInflater().inflate(R.layout.custom_layout, null);
            TextView textView_rowid = (TextView) view.findViewById(R.id.textView_rowid);
            TextView textView_jname = (TextView) view.findViewById(R.id.textView_jname);
            TextView textView_jnumber = (TextView) view.findViewById(R.id.textView_jnumber);

            // cursor fetches all records in outside method, this is for assignment purposes

            cursor.moveToPosition(i);

            //cursor.moveToFirst();
            textView_rowid.setText(cursor.getString(0));
            textView_jname.setText(cursor.getString(1));
            textView_jnumber.setText(cursor.getString(2));


            return view;
        }
    }

}

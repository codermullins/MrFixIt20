package net.androidbootcamp.mrfixit20;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import net.androidbootcamp.mrfixit20.database.DBHelper;
import net.androidbootcamp.mrfixit20.model.Parts;
import net.androidbootcamp.mrfixit20.model.PartsAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class PartListActivity extends AddApplianceActivity implements PartsAdapter.PartItemListener {
    private static final String TAG = "PartListActivity";
    PartsAdapter partsAdapter;

    private DBHelper mDatabase;
    ArrayList<String>partName, partNumber, partCost, partInv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appliance_view);
        Intent extras = getIntent();
        final String passedSerial = extras.getStringExtra("appSerial");
        setTitle(passedSerial);
        mDatabase = new DBHelper(this);

        partName = new ArrayList<>();
        partNumber = new ArrayList<>();
        partCost = new ArrayList<>();
        partInv = new ArrayList<>();

        displayParts();

        RecyclerView recyclerView = findViewById(R.id.appList);
        recyclerView.setLayoutManager(new LinearLayoutManager(PartListActivity.this));
        partsAdapter = new PartsAdapter(this, partName, partNumber, partCost, partInv, this);
        recyclerView.setAdapter(partsAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(PartListActivity.this));

        FloatingActionButton fab = findViewById(R.id.addApp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPartIntent = new Intent(PartListActivity.this, AddPartsActivity.class);
                addPartIntent.putExtra("appSerial", getTitle().toString().trim());
                startActivity(addPartIntent);
            }
        });

    }

    public void displayParts(){
        String passedSerial = getTitle().toString().trim();

        Cursor cursor = mDatabase.getParts(passedSerial);
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "No Data to Display", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {

                partName.add(cursor.getString(1));
                partNumber.add(cursor.getString(2));
                partCost.add(cursor.getString(3));
                partInv.add(cursor.getString(4));
            }
        }
    }

    @Override
    public void partItemClick(int position) {
        Intent partsListIntent = new Intent(this, PartListActivity.class);
        partsListIntent.putExtra("appSerial", getTitle());
        startActivity(partsListIntent);
    }
}

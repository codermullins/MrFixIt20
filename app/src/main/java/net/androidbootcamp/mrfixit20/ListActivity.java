package net.androidbootcamp.mrfixit20;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import net.androidbootcamp.mrfixit20.database.DBHelper;
import net.androidbootcamp.mrfixit20.model.Appliance;
import net.androidbootcamp.mrfixit20.model.ApplianceAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity{

    private static final String TAG = "ListActivity";
    ApplianceAdapter applianceAdapter;

    private DBHelper mDatabase;
    ArrayList<String>appMake, appModel, appSerial, appType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appliance_view);
        Log.d(TAG, "onCreate: started.");
        mDatabase = new DBHelper(ListActivity.this);

        appMake = new ArrayList<>();
        appModel = new ArrayList<>();
        appSerial = new ArrayList<>();
        appType = new ArrayList<>();

        displayAppliances();

        Log.d(TAG,"initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.appList);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));
        applianceAdapter = new ApplianceAdapter(ListActivity.this, appMake, appModel, appSerial, appType);
        recyclerView.setAdapter(applianceAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));


        FloatingActionButton fab = findViewById(R.id.addApp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addApplianceIntent = new Intent(ListActivity.this, AddApplianceActivity.class);
                startActivity(addApplianceIntent);
            }
        });

    }

    public void displayAppliances(){
        Cursor cursor = mDatabase.getAllAppliances();
        if(cursor.getCount() == 0) {
            Toast.makeText(this, "No Data to Display", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {

                appMake.add(cursor.getString(1));
                appModel.add(cursor.getString(2));
                appSerial.add(cursor.getString(3));
                appType.add(cursor.getString(4));
            }
        }
    }

}

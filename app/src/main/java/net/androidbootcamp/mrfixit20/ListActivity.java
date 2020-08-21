package net.androidbootcamp.mrfixit20;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import net.androidbootcamp.mrfixit20.database.DBHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity{
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appliance_view);
        DBHelper db = new DBHelper(this);
        ArrayList<HashMap<String, String>> app_list = db.GetAppliances();
        ListView appLV = (ListView) findViewById(R.id.appList);
        ListAdapter appAdapter = new SimpleAdapter(ListActivity.this, app_list, R.layout.appliance_row, new String[]
                {"make", "model", "serial", "type"}, new int[]{R.id.appMake, R.id.appModel, R.id.appSerial, R.id.appType});
        appLV.setAdapter(appAdapter);

        addButton = (Button) findViewById(R.id.newButton);
        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent addApplianceIntent = new Intent(ListActivity.this, AddApplianceActivity.class);
                startActivity(addApplianceIntent);
            }
        });

    }


}

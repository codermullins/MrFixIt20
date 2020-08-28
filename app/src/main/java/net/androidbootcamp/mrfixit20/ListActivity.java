package net.androidbootcamp.mrfixit20;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import net.androidbootcamp.mrfixit20.database.DBHelper;
import net.androidbootcamp.mrfixit20.model.Appliance;
import net.androidbootcamp.mrfixit20.model.ApplianceAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class ListActivity extends AppCompatActivity{

    private static final String TAG = "ListActivity";
    private ApplianceAdapter mApplianceAdapter;

    private DBHelper mDatabase;

//    private RecyclerView recyclerView;
//    private RecyclerView.Adapter mAdapter;
//    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appliance_view);
        Log.d(TAG, "onCreate: started.");


//        initRecyclerView();
        Log.d(TAG,"initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.appList);
        recyclerView.setLayoutManager(new LinearLayoutManager(ListActivity.this));
        mApplianceAdapter = new ApplianceAdapter(this, new ArrayList<Appliance>());
        recyclerView.setAdapter(mApplianceAdapter);


        FloatingActionButton fab = findViewById(R.id.addApp);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addApplianceIntent = new Intent(ListActivity.this, AddApplianceActivity.class);
                startActivity(addApplianceIntent);
            }
        });

//        ArrayList<HashMap<String, String>> app_list = db.GetAppliances();
//        recyclerView = (RecyclerView) findViewById(R.id.applianceList);
//
//
//        appLV.setAdapter(new ApplianceAdapter(this, appLV));
//
//        appLV.setLayoutManager(new LinearLayoutManager(this));
//
//        holder.parentView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent partListIntent(ListActivity.this, PartListActivity.class);
//                partListIntent.putExtra("appSerial", appliance);
//                startActivity(partListIntent);
//            }
//        });

//        ListAdapter appAdapter = new SimpleAdapter(ListActivity.this, app_list, R.layout.appliance_row, new String[]
//                {"make", "model", "serial", "type"}, new int[]{R.id.appMake, R.id.appModel, R.id.appSerial, R.id.appType});

//        appLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                TextView itemClicked = (TextView) view.findViewById(R.id.appSerial);
//                Toast.makeText(ListActivity.this, itemClicked.getText() , Toast.LENGTH_LONG).show();
//                Intent partListIntent = new Intent(ListActivity.this, PartListActivity.class);
//                partListIntent.putExtra("appSerial", itemClicked.getText() );
//                startActivity(partListIntent);
//            }
//        });
//
//        addButton = (Button) findViewById(R.id.newButton);
//        addButton.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                Intent addApplianceIntent = new Intent(ListActivity.this, AddApplianceActivity.class);
//                startActivity(addApplianceIntent);
//            }
//        });

    }

//    private void initRecyclerView() {
//        Log.d(TAG,"initRecyclerView: init recyclerview.");
//        RecyclerView recyclerView = findViewById(R.id.appList);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        mApplianceAdapter = new ApplianceAdapter(this, new ArrayList<Appliance>());
//        recyclerView.setAdapter(mApplianceAdapter);
//
//    }

}

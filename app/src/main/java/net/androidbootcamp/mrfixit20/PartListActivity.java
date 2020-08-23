package net.androidbootcamp.mrfixit20;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import net.androidbootcamp.mrfixit20.database.DBHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class PartListActivity extends AddApplianceActivity{
    Button addButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part_view);
        DBHelper db = new DBHelper(this);
        Intent extras = getIntent();
        String passedSerial = extras.getStringExtra("appSerial");
        final TextView serialText = (TextView)findViewById(R.id.selSerial);
        serialText.setText(passedSerial);
        ArrayList<HashMap<String, String>> part_list = db.GetParts();
        ListView partLV = (ListView)findViewById(R.id.partList);
        ListAdapter partAdapter = new SimpleAdapter(PartListActivity.this,
        part_list, R.layout.parts_row, new String[]{"partName", "partNumber", "partCost","partInv"},
                new int[]{R.id.partName, R.id.partNumber, R.id.partCost, R.id.partInv});
        partLV.setAdapter(partAdapter);


        addButton = (Button)findViewById(R.id.newPart);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addPartIntent = new Intent(PartListActivity.this, AddPartsActivity.class);
                addPartIntent.putExtra("appSerial", serialText.getText());
                startActivity(addPartIntent);
                Toast.makeText(PartListActivity.this, "Works", Toast.LENGTH_LONG).show();
            }
        });
    }
}

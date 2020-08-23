package net.androidbootcamp.mrfixit20;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.androidbootcamp.mrfixit20.database.DBHelper;
import net.androidbootcamp.mrfixit20.model.Appliance;

public class AddApplianceActivity extends AppCompatActivity{
    DBHelper db;
    EditText makeInput;
    EditText modelInput;
    EditText serialInput;
    EditText typeInput;
    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.appliance_add);
        db = new DBHelper(this);

        makeInput = (EditText)findViewById(R.id.makeInput);
        modelInput = (EditText)findViewById(R.id.modelInput);
        serialInput = (EditText)findViewById(R.id.serialInput);
        typeInput = (EditText)findViewById(R.id.typeInput);
        addBtn = (Button) findViewById(R.id.addBtn);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    if(!db.isSerialExists(serialInput.getText().toString().trim())) {
                        Toast.makeText(AddApplianceActivity.this, "Appliance Successfully added", Toast.LENGTH_LONG).show();
                        db.insertAppliance(new Appliance(makeInput.getText().toString().trim(), modelInput.getText().toString().trim(),
                                serialInput.getText().toString().trim(), typeInput.getText().toString().trim()));
                        Intent listIntent = new Intent(AddApplianceActivity.this, ListActivity.class);
                        startActivity(listIntent);
                    }

                    else {
                        Toast.makeText(AddApplianceActivity.this, "Serial already exists!", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }

    public boolean validate() {
        boolean valid = true;

        String appMake = makeInput.getText().toString();
        String appModel = modelInput.getText().toString();
        String appSerial = serialInput.getText().toString();
        String appType = typeInput.getText().toString();

        if (appMake.isEmpty()) {
            makeInput.setError("Enter the make");
            valid = false;
        }
        else {
            makeInput.setError(null);
        }

        if (appModel.isEmpty()) {
            modelInput.setError("Enter model number");
            valid = false;
        }
        else {
            modelInput.setError(null);
        }

        if (appSerial.isEmpty()) {
            serialInput.setError("Enter the serial number");
            valid = false;
        }
        else {
            serialInput.setError(null);
        }

        if (appType.isEmpty()) {
            typeInput.setError("Enter the type of appliance");
            valid = false;
        }
        else {
            typeInput.setError(null);
        }

        return valid;
    }
}

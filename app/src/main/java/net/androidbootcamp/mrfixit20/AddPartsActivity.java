package net.androidbootcamp.mrfixit20;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import net.androidbootcamp.mrfixit20.database.DBHelper;
import net.androidbootcamp.mrfixit20.model.Parts;

public class AddPartsActivity extends AppCompatActivity {
    DBHelper db;
    EditText appPartSerial;
    EditText partNameInput;
    EditText partNumberInput;
    EditText partCostInput;
    EditText partInvInput;
    Button partSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.part_add);
        db = new DBHelper(this);
        Intent extras = getIntent();
        String passedSerial = extras.getStringExtra("appSerial");
        appPartSerial = (EditText)findViewById(R.id.appPartSerial);
        appPartSerial.setText(passedSerial);
        partNameInput = (EditText)findViewById(R.id.partNameInput);
        partNumberInput = (EditText)findViewById(R.id.partNumberInput);
        partCostInput = (EditText)findViewById(R.id.partCostInput);
        partInvInput = (EditText)findViewById(R.id.partInvInput);
        partSubmit = (Button)findViewById(R.id.addBtn);


        partSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()) {
                    if(!db.isPartNumber(partNumberInput.getText().toString().trim())) {
                        Toast.makeText(AddPartsActivity.this, "Part Successfully Added", Toast.LENGTH_SHORT).show();
                        db.insertPart(new Parts(appPartSerial.getText().toString().trim(), partNameInput.getText().toString().trim(), partNumberInput.getText().toString().trim(),
                                partCostInput.getText().toString().trim(), partInvInput.getText().toString().trim()));
                        Intent partListIntent = new Intent(AddPartsActivity.this, PartListActivity.class);
                        Log.i("Passed Value", appPartSerial.toString());
                        partListIntent.putExtra("appSerial", appPartSerial.getText());
                        setResult(RESULT_OK, partListIntent);
                        finish();
                    }
                }
            }
        });
    }

    public boolean validate() {
        boolean valid = true;

        String partName = partNameInput.getText().toString();
        String partNumber = partNumberInput.getText().toString();
        String partCost = partCostInput.getText().toString();
        String partInv = partInvInput.getText().toString();

        if (partName.isEmpty()) {
            partNameInput.setError("Enter name of part");
            valid = false;
        }
        else {
            partNameInput.setError(null);
        }

        if (partNumber.isEmpty()) {
            partNumberInput.setError("Enter part number");
            valid = false;
        }
        else {
            partNumberInput.setError(null);
        }

        if (partCost.isEmpty()) {
            partCostInput.setError("Enter cost of part");
            valid = false;
        }
        else {
            partCostInput.setError(null);
        }

        if (partInv.isEmpty()) {
            partInvInput.setError("Enter Inventory of part");
            valid = false;
        }
        else {
            partInvInput.setError(null);
        }

        return valid;
    }
}

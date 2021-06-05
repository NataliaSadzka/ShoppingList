package com.example.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.example.recyclerview.database.AppDatabase;
import com.example.recyclerview.database.Product;

public class AddNewProductActivity extends Activity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_row);

        final EditText nameInput = findViewById(R.id.nameInput);
        final Spinner spinner = findViewById(R.id.spinner1);
        Button saveButton = findViewById(R.id.saveButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewProduct(nameInput.getText().toString(), spinner.getSelectedItem().toString());

            }
        });
    }

    private void saveNewProduct(String name, String quantityUnit) {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        Product product = new Product();
        product.setName(name);
        product.setQuantityUnit(quantityUnit);

        db.productDao().insertProduct(product);
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

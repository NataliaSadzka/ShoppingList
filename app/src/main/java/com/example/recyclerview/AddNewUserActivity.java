package com.example.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.recyclerview.database.AppDatabase;
import com.example.recyclerview.database.User;

public class AddNewUserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        final EditText nameInput = findViewById(R.id.nameInput);
        final EditText surnameInput = findViewById(R.id.surnameInput);
        Button saveButton = findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(nameInput.getText().toString(), surnameInput.getText().toString());

            }
        });
    }

    private void saveNewUser(String name, String surname) {
        AppDatabase db = AppDatabase.getDbInstance(this.getApplicationContext());

        User user = new User();
        user.name = name;
        user.surname = surname;

        db.userDao().insertUser(user);
        finish();

    }
}

package com.example.quest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class StartActivity extends AppCompatActivity {
    private TextView textView;
    private EditText editTextName;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        textView = findViewById(R.id.textView);
        editTextName = findViewById(R.id.editTextName);
        button = findViewById(R.id.button);

        button.setText("Начать игру");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("name", editTextName.getText().toString());
                startActivity(intent);
            }
        });
    }
}
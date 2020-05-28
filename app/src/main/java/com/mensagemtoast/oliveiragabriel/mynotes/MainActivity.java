package com.mensagemtoast.oliveiragabriel.mynotes;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private EditText note;
    private static final String NOTES = "notes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        note = findViewById(R.id.note);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(NOTES,0);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("notes", note.getText().toString());
                Toast.makeText(MainActivity.this, "Dados salvos com sucesso", Toast.LENGTH_LONG).show();
                editor.commit();

            }
        });

        SharedPreferences sharedPreferences = getSharedPreferences(NOTES, Context.MODE_PRIVATE);
        if (sharedPreferences.contains("notes")){
            String savedNotes = sharedPreferences.getString("notes", "");
            note.setText(savedNotes);
        }


    }
}

package com.example.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

public class NewNoteActivity extends AppCompatActivity {

    EditText noteEditText;
    String contents;
    int id;

    @Override
    protected void onPause() {
        super.onPause();
        MainActivity.notesDatabase.noteDao().save(noteEditText.getText().toString(), id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        noteEditText = findViewById(R.id.note_edit_text);

        // Get the contents from the main activity
        contents = getIntent().getStringExtra("contents");
        id  = getIntent().getIntExtra("id", 0);
        noteEditText.setText(contents);
    }
}
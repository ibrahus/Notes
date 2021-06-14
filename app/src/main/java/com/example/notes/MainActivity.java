package com.example.notes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    NotesAdapter notesAdapter;
    FloatingActionButton floatingActionButton;
    RecyclerView.LayoutManager layoutManager;
    public static NotesDatabase notesDatabase;

    @Override
    protected void onResume() {
        super.onResume();
        notesAdapter.reload();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesDatabase = Room.databaseBuilder(getApplicationContext(), NotesDatabase.class, "notes")
                .allowMainThreadQueries()
                .build();

        recyclerView = findViewById(R.id.recyclerview);
        layoutManager = new LinearLayoutManager(this);
        notesAdapter = new NotesAdapter();
        floatingActionButton = findViewById(R.id.add_note_button);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(notesAdapter);
        //Display all the notes
        notesAdapter.reload();

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
            notesDatabase.noteDao().deleteNote(notesAdapter.getNoteAt(viewHolder.getBindingAdapterPosition()));
            Toast.makeText(getApplicationContext(), "Note Deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);

    }
    // On click for floating action button
    public void addNote(View view) {
            notesDatabase.noteDao().create();
            notesAdapter.reload();
        Toast.makeText(getApplicationContext(), "Note Created", Toast.LENGTH_SHORT).show();

    }
}
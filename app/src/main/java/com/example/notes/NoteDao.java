package com.example.notes;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Query;

import java.util.List;

// Interact with the table
@Dao
public interface NoteDao {
    @Query("INSERT INTO notes (contents) VALUES ('new note')")
    void create();

    @Query("SELECT * FROM notes")
    List<Note> getAllNotes();

    @Query("UPDATE notes SET contents = :contents WHERE id = :id")
    void save(String contents, int id);

//    @Query("DELETE FROM notes WHERE id = :id")
    @Delete
    void deleteNote(Note note);
}

package com.example.notes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

// Define the table
@Entity(tableName = "notes")
public class Note {
    @PrimaryKey
    public int id;

    @ColumnInfo
    public String contents;
}

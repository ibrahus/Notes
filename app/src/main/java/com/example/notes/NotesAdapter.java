package com.example.notes;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesViewHolder> {

    private List<Note> noteList = new ArrayList<>();

    @NonNull
    @NotNull
    @Override
    public NotesViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.note_row, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull NotesAdapter.NotesViewHolder holder, int position) {
        Note current_note = noteList.get(position);
        holder.noteText.setText(current_note.contents);
        holder.linearLayout.setTag(current_note);
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    // Load all notes from DB
    public void reload(){
        noteList = MainActivity.notesDatabase.noteDao().getAllNotes();
        notifyDataSetChanged();
    }

    public Note getNoteAt(int position){
        return noteList.get(position);
    }

    public static class NotesViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayout;
        TextView noteText;

        public NotesViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linear_layout);
            noteText = itemView.findViewById(R.id.note_text);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Note current_note = (Note) linearLayout.getTag();
                    Intent intent = new Intent(v.getContext(), NewNoteActivity.class);
                    intent.putExtra("contents", current_note.contents);
                    intent.putExtra("id", current_note.id);

                    v.getContext().startActivity(intent);
                }
            });
        }
    }

}

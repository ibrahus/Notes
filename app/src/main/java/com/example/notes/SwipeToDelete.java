//package com.example.notes;
//
//import android.widget.Adapter;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.ItemTouchHelper;
//import androidx.recyclerview.widget.RecyclerView;
//
//import org.jetbrains.annotations.NotNull;
//
//public class SwipeToDelete extends ItemTouchHelper.SimpleCallback {
//
//    NotesAdapter mAdapter;
//
//    public SwipeToDelete(NotesAdapter adapter) {
//        super(0,ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT);
//        mAdapter = adapter;
//    }
//
//    @Override
//    public boolean onMove(@NonNull @NotNull RecyclerView recyclerView, @NonNull @NotNull RecyclerView.ViewHolder viewHolder, @NonNull @NotNull RecyclerView.ViewHolder target) {
//        return false;
//    }
//
//    @Override
//    public void onSwiped(@NonNull @NotNull RecyclerView.ViewHolder viewHolder, int direction) {
//
//    }
//}

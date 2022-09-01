package com.example.dentalmanager;

import androidx.cardview.widget.CardView;

import Models.Notes;

public interface NotesClickListener {

    void onClick (Notes notes);
    void onLongClick(Notes notes, CardView cardView);

}
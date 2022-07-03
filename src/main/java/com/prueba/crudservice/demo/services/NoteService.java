package com.prueba.crudservice.demo.services;

import com.prueba.crudservice.demo.models.Note;

import java.util.List;

public interface NoteService {

    Note addNote(Note note);

    Note findNote(Long id);

    List<Note> editNote(Note note);

    List<Note> findAll();

    List<Note> findAllByCategory(String category);

    List<Note> findAllFavs();

    boolean deleteNote(Long id);
}

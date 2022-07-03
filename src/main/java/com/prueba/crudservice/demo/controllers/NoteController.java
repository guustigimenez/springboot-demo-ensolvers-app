package com.prueba.crudservice.demo.controllers;

import com.prueba.crudservice.demo.models.Note;
import com.prueba.crudservice.demo.services.NoteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }
    @CrossOrigin(origins = "https://jdb-prueba-android.web.app")
    @PostMapping
    private ResponseEntity<Note> addNote(@RequestBody Note note){
        return ResponseEntity.ok(noteService.addNote(note));
    }
    @CrossOrigin(origins = "https://jdb-prueba-android.web.app")
    @GetMapping("/{id}")
    private ResponseEntity<Note> fetchNote(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(noteService.findNote(id));
    }
    @CrossOrigin(origins = "https://jdb-prueba-android.web.app")
    @PutMapping
    private ResponseEntity<?> editNote(@RequestBody Note note){
        return ResponseEntity.ok(noteService.editNote(note));
    }

    @CrossOrigin(origins = "https://jdb-prueba-android.web.app")
    @GetMapping
    private ResponseEntity<List<Note>> fetchAllNotes(){
        return ResponseEntity.ok(noteService.findAll());
    }
    @CrossOrigin(origins = "https://jdb-prueba-android.web.app")
    @GetMapping("/filtered")
    private ResponseEntity<List<Note>> fetchAllByCategory(@RequestParam("categoria") String category){
        return ResponseEntity.ok(noteService.findAllByCategory(category));
    }
    @CrossOrigin(origins = "https://jdb-prueba-android.web.app")
    @GetMapping("/archived")
    private ResponseEntity<List<Note>> fetchAllFavs(){
        return ResponseEntity.ok(noteService.findAllFavs());
    }
    @CrossOrigin(origins = "https://jdb-prueba-android.web.app")
    @DeleteMapping("/delete/{id}")
    private ResponseEntity<?> deleteNote(@PathVariable(name = "id") Long id){
        return ResponseEntity.ok(noteService.deleteNote(id));
    }

}

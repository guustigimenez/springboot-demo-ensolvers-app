package com.prueba.crudservice.demo.services.implementations;

import com.prueba.crudservice.demo.exceptions.NotFoundException;
import com.prueba.crudservice.demo.models.Note;
import com.prueba.crudservice.demo.models.User;
import com.prueba.crudservice.demo.repositories.NotesRepository;
import com.prueba.crudservice.demo.services.NoteService;
import com.prueba.crudservice.demo.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

@Service("noteService")
public class NoteServiceImpl implements NoteService {

    private static Logger logger = LoggerFactory.getLogger(NoteServiceImpl.class);

    @Autowired
    private UserService userService;
    @Autowired
    private NotesRepository notesRepository;

    @Override
    public Note addNote(Note note) {
        try{
            User user = userService.findById(note.getUserId());
            if(Objects.nonNull(user)){
                user.addNote(note);
            }
            note.setLastEdited(Date.from(Instant.now()));
        }catch (NotFoundException e){
            throw new NotFoundException("No se encontró al usuario");
        }
        return notesRepository.saveAndFlush(note);
    }

    @Override
    public Note findNote(Long id) {
        logger.info(id.toString());
        return notesRepository.findNoteById(id).orElseThrow(
                () -> new NotFoundException("Nota no encontrada")
        );
    }

    @Override
    public List<Note> editNote(Note note) {
        try {
            findNote(note.getId());
            notesRepository.save(note);
            return findAll();
        }catch (Exception e){
            throw new NotFoundException("Error al intentar editar la nota");
        }
    }

    @Override
    public List<Note> findAll() {
        try{
            return notesRepository.findAll();
        } catch (Exception e){
            throw new NotFoundException("No se encontraron notas");
        }
    }

    @Override
    public List<Note> findAllByCategory(String category) {
        return findAll()
                .stream()
                .filter( e -> e.getCategories().contains(category))
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> findAllFavs() {
        return findAll()
                .stream()
                .filter( e -> e.isFav())
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteNote(Long id) {
        Note noteToDelete = findNote(id);
        try{
            User user = userService.findById(noteToDelete.getUserId());
            user.removeNote(noteToDelete);
            notesRepository.delete(noteToDelete);
        }catch (Exception e){
            throw new NotFoundException("No se encontro la nota");
        }
        return true;
    }
}

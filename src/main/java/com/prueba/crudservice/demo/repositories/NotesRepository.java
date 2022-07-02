package com.prueba.crudservice.demo.repositories;

import com.prueba.crudservice.demo.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NotesRepository extends JpaRepository<Note, Long> {

    Optional<Note> findNoteById(Long id);

}

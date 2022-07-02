package com.prueba.crudservice.demo.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name= "Usuario", nullable = false)
    private String username;
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name ="contraseña", nullable = false)
    private String password;

    @ElementCollection
    private List<Note> activeNotes;

    public User() {
    }

    public User(long id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Note> getActiveNotes() {
        return activeNotes;
    }

    public void setActiveNotes(List<Note> activeNotes) {
        this.activeNotes = activeNotes;
    }

    public void addNote(Note note){
        this.activeNotes.add(note);
    }

    public void removeNote(Note note){
        this.activeNotes.remove(note);
    }

}

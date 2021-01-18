package com.ssau.restfulesa.api;

import com.ssau.restfulesa.entity.*;
import com.ssau.restfulesa.notice.JmsSender;
import com.ssau.restfulesa.repository.NotesRepository;
import com.ssau.restfulesa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(method={RequestMethod.POST,RequestMethod.GET})
public class Api {

    private final UserRepository userRepository;
    private final NotesRepository notesRepository;
    private final JmsSender jmsSender;

    @Autowired
    public Api(UserRepository userRepository, NotesRepository notesRepository, JmsSender jmsSender) {
        this.userRepository = userRepository;
        this.notesRepository = notesRepository;
        this.jmsSender = jmsSender;
    }

    @GetMapping(value = "/userJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<User> getAllUser(){
        return this.userRepository.findAll();
    }

    @GetMapping(value = "/notesJson", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Notes> getAllNotes(){
        return this.notesRepository.findAll();
    }

    @GetMapping(value = "/userXml", produces = {MediaType.APPLICATION_XML_VALUE})
    public UserXML getAllUsersXml(){
        return new UserXML((List<User>) this.userRepository.findAll());
    }

    @GetMapping(value = "/notesXml", produces = {MediaType.APPLICATION_XML_VALUE})
    public NotesXML getAllNotesXml(){
        return new NotesXML((List<Notes>) this.notesRepository.findAll());
    }

    @PostMapping(value = "/userAdd")
    public String addUser(@RequestBody @ModelAttribute("user") User user){
        jmsSender.sendObjectUpdate(user, "ADD");
        String body = "Add User: " + user.toString();
        Email email = new Email(UUID.randomUUID().toString(), body);
        jmsSender.sendEmail(email);
        userRepository.save(user);
        return "redirect:/users";
    }

    @PostMapping(value = "/notesAdd")
    public String addNotes(@ModelAttribute("notes") Notes notes){
        jmsSender.sendObjectUpdate(notes, "ADD");
        String body = "Add Faculty: " + notes.toString();
        Email email = new Email(UUID.randomUUID().toString(), body);
        jmsSender.sendEmail(email);
        notesRepository.save(notes);
        return "redirect:/notes";
    }

    @DeleteMapping(value = "/userDelete/{id}")
    public String deleteUser(@PathVariable("id") int id){
        User user = this.userRepository.findById(id).orElse(null);
        if (user==null)
            return null;
        jmsSender.sendObjectUpdate(user, "DELETE");
        String body = "Delete User: " + user.toString();
        Email email = new Email(UUID.randomUUID().toString(), body);
        jmsSender.sendEmail(email);
        userRepository.delete(user);
        return "redirect:/users";
    }

    @DeleteMapping(value = "/notesDelete/{id}")
    public String deleteNotes(@PathVariable("id") int id_note){
        Notes notes = this.notesRepository.findById(id_note).orElse(null);
        if (notes==null)
            return null;
        jmsSender.sendObjectUpdate(notes, "DELETE");
        String body = "Delete Notes: " + notes.toString();
        Email email = new Email(UUID.randomUUID().toString(), body);
        jmsSender.sendEmail(email);
        notesRepository.delete(notes);
        return "redirect:/notes";
    }
}
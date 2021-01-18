package com.ssau.restfulesa.api;

import com.ssau.restfulesa.entity.Notes;
import com.ssau.restfulesa.entity.NotesXML;
import com.ssau.restfulesa.entity.User;
import com.ssau.restfulesa.entity.UserXML;
import com.ssau.restfulesa.repository.NotesRepository;
import com.ssau.restfulesa.repository.UserRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/notes")
public class NotesApi {

    @Autowired
    NotesRepository notesRepository;

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private List<Notes> getNotes() {

        return this.notesRepository.findAll();
    }

    @RequestMapping(value="/id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Notes> getNotesByID(@PathVariable(value = "id") Integer notesID)
            throws NotFoundException {
        Notes notes = notesRepository.findById(notesID)
                .orElseThrow(() -> new NotFoundException("Отсутствует пользователь по этому id :: " + notesID));
        return ResponseEntity.ok().body(notes);
    }
    @RequestMapping(value = "/xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    private NotesXML getNotesXML() {
        return new NotesXML((List<Notes>) this.notesRepository.findAll());
    }

}

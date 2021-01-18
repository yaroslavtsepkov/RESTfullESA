package com.ssau.restfulesa.api;

import com.ssau.restfulesa.entity.User;
import com.ssau.restfulesa.entity.UserXML;
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
@RequestMapping("/users")
public class UserApi {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/json", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    private List<User> getUsers() {

        return this.userRepository.findAll();
    }

    @RequestMapping(value="/id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Integer userID)
            throws NotFoundException {
        User user = userRepository.findById(userID)
                .orElseThrow(() -> new NotFoundException("Отсутствует пользователь по этому id :: " + userID));
        return ResponseEntity.ok().body(user);
    }
    @RequestMapping(value = "/xml", method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    private UserXML getUsersXML() {
        return new UserXML((List<User>) this.userRepository.findAll());
    }

}

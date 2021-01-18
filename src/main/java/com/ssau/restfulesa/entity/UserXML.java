package com.ssau.restfulesa.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "users")
public class UserXML {
    @XmlElement
    List<User> users = new ArrayList<>();

    public UserXML() {
    }

    public List<User> getUsers() {
        return users;
    }

    public UserXML(List<User> users) {
        this.users = users;
    }
}

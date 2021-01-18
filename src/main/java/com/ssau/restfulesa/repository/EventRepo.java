package com.ssau.restfulesa.repository;

import com.ssau.restfulesa.entity.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepo extends CrudRepository<Event, Integer> {
}

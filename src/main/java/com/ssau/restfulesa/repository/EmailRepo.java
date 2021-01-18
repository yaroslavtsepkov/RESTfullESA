package com.ssau.restfulesa.repository;

import com.ssau.restfulesa.entity.Email;
import org.springframework.data.repository.CrudRepository;

public interface EmailRepo extends CrudRepository<Email, Integer> {
}
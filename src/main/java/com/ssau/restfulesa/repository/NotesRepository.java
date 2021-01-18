package com.ssau.restfulesa.repository;

import com.ssau.restfulesa.entity.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepository extends JpaRepository<Notes, Integer> {
}

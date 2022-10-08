package com.hertz.assignment.librarysystem.repository;

import com.hertz.assignment.librarysystem.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}

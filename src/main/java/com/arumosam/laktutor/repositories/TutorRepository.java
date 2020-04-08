package com.arumosam.laktutor.repositories;

import com.arumosam.laktutor.models.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorRepository extends JpaRepository<Tutor, Integer> {
}

package com.fitverse.stayfiit.Exercises;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ExerciseRepository extends JpaRepository<Exercise,Long> {
}

package com.fitverse.stayfiit.Exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseService {

    private final ExerciseRepository exerciseRepository;

    @Autowired
    public ExerciseService(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;
    }

    public List<Exercise> getAllExercise() {
        return exerciseRepository.findAll();
    }

    public Exercise addNewExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    public void deleteUserById(Long exId) {
        boolean exists = exerciseRepository.existsById(exId);
        if (!exists) {
            throw new IllegalStateException("Exercise with Id " + exId + " doesn't exist");
        }
        exerciseRepository.deleteById(exId);
    }

    public Exercise updateNewExercise(Long exId, Exercise updatedExercise) {
        Exercise exercise = exerciseRepository.findById(exId)
                .orElseThrow(() -> new IllegalStateException("Exercise with Id " + exId + " doesn't exist"));

        exercise.setName(updatedExercise.getName());
        exercise.setSets(updatedExercise.getSets());
        exercise.setReps(updatedExercise.getReps());
        exercise.setWeight(updatedExercise.getWeight());

        return exerciseRepository.save(exercise);
    }
}


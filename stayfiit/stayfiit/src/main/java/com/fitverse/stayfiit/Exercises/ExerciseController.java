package com.fitverse.stayfiit.Exercises;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v3/exercise")
public class ExerciseController {
    private final ExerciseService exerciseService;

    @Autowired
    public ExerciseController(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @GetMapping("/all")
    public List<Exercise> getAllExercise() {
        return exerciseService.getAllExercise();
    }

    @PostMapping
    public Exercise registerNewExercise(@RequestBody Exercise exercise) {
        return exerciseService.addNewExercise(exercise);
    }

    @DeleteMapping(path = "{exId}")
    public void deleteUser(@PathVariable("exId") Long exId) {
        exerciseService.deleteUserById(exId);
    }

    @PutMapping(path = "{exId}")
    public Exercise updateExercise(@PathVariable("exId") Long exId, @RequestBody Exercise updatedExercise) {
        return exerciseService.updateNewExercise(exId, updatedExercise);
    }
}

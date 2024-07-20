package com.fitverse.stayfiit.Exercises;


import jakarta.persistence.*;

@Entity
@Table(name = "Exercise")

public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int Id;
    private String Name;
    private int Sets;
    private int Reps;
    private double Weight;


    public Exercise() {
    }

    public Exercise(int id, String name, int sets, int reps, double weight) {
        Id = id;
        Name = name;
        Sets = sets;
        Reps = reps;
        Weight = weight;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getSets() {
        return Sets;
    }

    public void setSets(int sets) {
        Sets = sets;
    }

    public int getReps() {
        return Reps;
    }

    public void setReps(int reps) {
        Reps = reps;
    }

    public double getWeight() {
        return Weight;
    }

    public void setWeight(double weight) {
        Weight = weight;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Sets=" + Sets +
                ", Reps=" + Reps +
                ", Weight=" + Weight +
                '}';
    }
}

package com.training.sgorodecki.homework.homework8.homework8_2;

import java.util.Objects;
import java.util.Set;

public class Worker {
    private Set<Skill> workerSkills;
    private Double rate;

    public Set<Skill> getWorkerSkill() {
        return workerSkills;
    }

    public void setWorkerSkill(Set<Skill> workerSkills) {
        this.workerSkills = workerSkills;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Worker(Set<Skill> workerSkills, Double rate) {
        this.workerSkills = workerSkills;
        this.rate = rate;
    }

    public Worker(Set<Skill> workerSkills) {
        this.workerSkills = workerSkills;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(workerSkills, worker.workerSkills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(workerSkills);
    }
}

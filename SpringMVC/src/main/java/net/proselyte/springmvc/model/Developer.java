package net.proselyte.springmvc.model;

public class Developer {
    private double velocity;
    private String name;
    private String specialty;
    private int experience;

    public double getVelocity() {
        return velocity;
    }

    public void setId(double v) {
        this.velocity = v;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "velocity=" + velocity +
                ", name='" + name + '\'' +
                ", specialty='" + specialty + '\'' +
                ", experience=" + experience +
                '}';
    }
}

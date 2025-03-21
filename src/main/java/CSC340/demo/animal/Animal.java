package CSC340.demo.animal;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "animals")
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private int animalId;


    @Column(name="name",nullable = false)
    private String name;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="breed", nullable = false)
    private String breed;

    @Column(name="age", nullable = false)
    private double age;

    @Column(name="active_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date activeDate;

    public Animal() {
    }

    public Animal(String name, String description, String breed, double age, Date activeDate) {
        this.name = name;
        this.description = description;
        this.breed = breed;
        this.age = age;
        this.activeDate = activeDate;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public Date getActiveDate() {
        return activeDate;
    }

    public void setActiveDate(Date activeDate) {
        this.activeDate = activeDate;
    }
}

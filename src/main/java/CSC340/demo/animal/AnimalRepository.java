package CSC340.demo.animal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findByNameContaining(String name);
    List<Animal> findByAge(double age);
    List<Animal> findByBreed(String breed);
}


package CSC340.demo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository repository;

    public List<Animal> getAllAnimals() {
        return repository.findAll();
    }

    public Animal getAnimalById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Animal addNewAnimal(Animal animal) {
        return repository.save(animal);
    }

    public Animal updateAnimal(Animal animal) {
        return repository.save(animal);
    }

    public void deleteAnimal(int id) {
        repository.deleteById(id);
    }

    public List<Animal> findAnimalsByName(String name) {
        return repository.findByNameContaining(name);
    }

    public List<Animal> findAnimalsByAge(double age) {
        return repository.findByAge(age);
    }

    public List<Animal> findAnimalsByBreed(String breed) {
        return repository.findByBreed(breed);
    }
}

package CSC340.demo.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService service;

    //GET http://localhost:8080/animals/all
    @GetMapping("/all")
    public ResponseEntity<List<Animal>> getAllAnimals() {
        return new ResponseEntity<>(service.getAllAnimals(), HttpStatus.OK);
    }

    //GET http://localhost:8080/animals/1
    
    @GetMapping("/{animalId}")
    public ResponseEntity<?> getAnimalById(@PathVariable String animalId) {
        try {
            int id = Integer.parseInt(animalId);
            Animal animal = service.getAnimalById(id);
            return new ResponseEntity<>(animal, HttpStatus.OK);
        } catch (NumberFormatException e) {
            if ("new".equals(animalId)) {
                // Handle specific case or redirect
                return new ResponseEntity<>("This endpoint is for fetching animals by ID. To add a new animal, use POST /add.", HttpStatus.BAD_REQUEST);
            }
            return new ResponseEntity<>("Invalid ID format", HttpStatus.BAD_REQUEST);
        }
    }
    

    // http://localhost:8080/animals/new

    // Specific route for adding a new animal
    @PostMapping("/add")
    public ResponseEntity<Animal> addNewAnimal(@RequestBody Animal animal) {
        Animal savedAnimal = service.addNewAnimal(animal);
        return new ResponseEntity<>(savedAnimal, HttpStatus.CREATED);
    }

    // http://localhost:8080/animals/update/1

    @PutMapping("/update/{animalId}")
    public ResponseEntity<Animal> updateAnimal(@PathVariable int animalId, @RequestBody Animal animal) {
        animal.setAnimalId(animalId);
        return new ResponseEntity<>(service.updateAnimal(animal), HttpStatus.OK);
    }

    // http://localhost:8080/animals/delete/1

    @DeleteMapping("/delete/{animalId}")
    public ResponseEntity<HttpStatus> deleteAnimal(@PathVariable int animalId) {
        service.deleteAnimal(animalId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<Animal>> getAnimalsByName(@RequestParam String name) {
        return new ResponseEntity<>(service.findAnimalsByName(name), HttpStatus.OK);
    }

    @GetMapping("/by-age")
    public ResponseEntity<List<Animal>> getAnimalsByAge(@RequestParam double age) {
        return new ResponseEntity<>(service.findAnimalsByAge(age), HttpStatus.OK);
    }

    @GetMapping("/by-breed")
    public ResponseEntity<List<Animal>> getAnimalsByBreed(@RequestParam String breed) {
        return new ResponseEntity<>(service.findAnimalsByBreed(breed), HttpStatus.OK);
    }
}

package csci4448.AnimalShelter;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepo extends MongoRepository<Animal, String>{
}

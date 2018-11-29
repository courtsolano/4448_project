package csci4448.AnimalShelter;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface for the user repository that utilizes the mongo repository class
 */
@Repository
public interface UserRepo extends MongoRepository<Volunteer, String>{
}

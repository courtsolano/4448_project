package csci4448.AnimalShelter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo repo;

    @Autowired
    public UserService(UserRepo _repo) {
        repo = _repo;
    }

    public boolean userSignUp(String username, String password) {
        int id = (int)getCount() + 1;
        if (getUser(username) != null) {
            return false;
        }
        Volunteer v = new Volunteer(username, password, id);
        repo.save(v);
        return true;
    }

    private long getCount() {
        return repo.count();
    }

    public Volunteer getUser(String username) {
        Optional<Volunteer> a = repo.findById(username);
        return a.orElse(null);
    }
}

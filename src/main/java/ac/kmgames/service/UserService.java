package ac.kmgames.service;

import ac.kmgames.model.entity.User;
import ac.kmgames.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final public class UserService{
    private final UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElse(User.NULL);
    }

    public boolean save(User user){
        try{
            userRepository.save(user);
            return true;
        }catch(Exception ignored){
            return false;
        }
    }
}

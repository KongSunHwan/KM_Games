package ac.kmgames.service;

import ac.kmgames.model.entity.PaymentHistory;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
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
        return userRepository.findByEmail(email).orElse(User.NULL());
    }

    public List<User> getUsersByName(String name){
        return userRepository.findByNameContains(name);
    }

    public List<User> getUsersByNickname(String name){
        return userRepository.findByNicknameContains(name);
    }

    public boolean save(User user){
        try{
            userRepository.save(user);
            return true;
        }catch(Exception ignored){
            return false;
        }
    }

    public List<User> getAll(int page){
        return userRepository.findAll(PageRequest.of(page, 10)).getContent();
    }

    public long getCount(){
        return userRepository.count();
    }
}

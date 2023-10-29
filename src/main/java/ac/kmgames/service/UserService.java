package ac.kmgames.service;

import ac.kmgames.model.dto.ResponsePageDTO;
import ac.kmgames.model.dto.UserDTO;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.mapper.UserMapper;
import ac.kmgames.model.repository.UserRepository;
import ac.kmgames.model.utils.Criteria;
import ac.kmgames.model.utils.PageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
final public class UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public boolean existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElse(User.NULL());
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
        return userRepository.findAll(PageRequest.of(page, 5)).getContent();
    }

    public long getCount(){
        return userRepository.count();
    }

    public long getUserByName(String names){
        Optional<User> optionalUser = userRepository.findByNickname(names);
        User users = optionalUser.get();
        return users.getId();
    }

    public User findAllById(int id) {
        return userRepository.findAllById(id);
    }


    public Page<User> getFindByName(String keyword, Pageable pageable) {
        return userRepository.findByNameContains(keyword, pageable);
    }

    //admin user list + pagination
    public ResponsePageDTO.ResponseUser getUserListAdmin(Criteria criteria) {
        Criteria cs = new Criteria(criteria.getPageNum(), criteria.getAmount(), criteria.getType(), criteria.getKeyword());
        List<UserDTO> pageList = userMapper.getAll(cs);
        int total = userMapper.getCount(cs);
        PageDTO pageDTO = new PageDTO(cs,total);
        return new ResponsePageDTO.ResponseUser(pageList, pageDTO);
    }

    //admin user detail by id
    public UserDTO getUserDetail(int id) {
        return userMapper.getUserDetail(id);
    }
}

package ac.kmgames.model.mapper;

import ac.kmgames.model.dto.UserDTO;
import ac.kmgames.model.utils.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    //admin user list
    List<UserDTO> getAll(Criteria criteria);
    //admin user list count
    int getCount(Criteria criteria);

    //admin user detail
    UserDTO getUserDetail(int id);
}

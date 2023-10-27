package ac.kmgames.model.mapper;

import ac.kmgames.model.dto.UserDTO;
import ac.kmgames.model.utils.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<UserDTO> getAll(Criteria criteria);

    int getCount(Criteria criteria);
}

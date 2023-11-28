package ac.kmgames.model.mapper;

import ac.kmgames.model.dto.UserDTO;
import ac.kmgames.model.utils.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    //admin user list
    List<UserDTO> getAll(@Param("cri") Criteria criteria);
    //admin user list count
    int getCount(@Param("cri") Criteria criteria);

    //admin user detail
    UserDTO getUserDetail(int id);

    List<UserDTO> getUserListforDate(@Param("cri") Criteria criteria,
                                     @Param("startDate") String startDate,
                                     @Param("endDate") String endDate);

    int getUserListForDateCount(@Param("cri") Criteria criteria,
                                @Param("startDate") String startDate,
                                @Param("endDate") String endDate);
}

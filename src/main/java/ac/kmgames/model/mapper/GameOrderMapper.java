package ac.kmgames.model.mapper;

import ac.kmgames.model.dto.GODetailDTO;
import ac.kmgames.model.utils.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.core.parameters.P;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GameOrderMapper {
    List<HashMap> getGODetail(@Param("id") int id, @Param("cs") Criteria cs);
    List<GODetailDTO> getGODetail1(@Param("id") int id, @Param("cs") Criteria cs);

    int getCountGODetail(@Param("id") int id, @Param("cs") Criteria cs);
}

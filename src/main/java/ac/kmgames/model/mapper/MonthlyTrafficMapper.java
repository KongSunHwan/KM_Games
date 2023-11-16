package ac.kmgames.model.mapper;

import ac.kmgames.model.dto.MonthlyTrafficDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MonthlyTrafficMapper {
    List<MonthlyTrafficDTO> getMonthlyTraffic();
}

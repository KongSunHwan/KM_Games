package ac.kmgames.model.mapper;

import ac.kmgames.model.dto.GameDataDTO;
import ac.kmgames.model.dto.MonthlyTrafficDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MonthlyTrafficMapper {
    List<MonthlyTrafficDTO> getMonthlyTraffic(@Param("sd") String startDates, @Param("ed") String endDates);

    List<GameDataDTO> getRatios();
}

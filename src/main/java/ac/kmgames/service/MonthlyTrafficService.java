package ac.kmgames.service;

import ac.kmgames.model.dto.MonthlyTrafficDTO;
import ac.kmgames.model.mapper.MonthlyTrafficMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
final public class MonthlyTrafficService {

    private final MonthlyTrafficMapper monthlyTrafficMapper;

    public List<MonthlyTrafficDTO> getMonthlyTraffic() {
        return monthlyTrafficMapper.getMonthlyTraffic();
    }
}

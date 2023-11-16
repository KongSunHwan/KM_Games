package ac.kmgames.service;

import ac.kmgames.model.dto.GameDTO;
import ac.kmgames.model.dto.MonthlyTrafficDTO;
import ac.kmgames.model.dto.ResponsePageDTO;
import ac.kmgames.model.entity.Game;
import ac.kmgames.model.mapper.GameMapper;
import ac.kmgames.model.mapper.MonthlyTrafficMapper;
import ac.kmgames.model.repository.GameRepository;
import ac.kmgames.model.utils.Criteria;
import ac.kmgames.model.utils.PageDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
final public class MonthlyTrafficService {

    private final MonthlyTrafficMapper monthlyTrafficMapper;

    public List<MonthlyTrafficDTO> getMonthlyTraffic() {
        return monthlyTrafficMapper.getMonthlyTraffic();
    }

}

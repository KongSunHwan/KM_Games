package ac.kmgames.service;

import ac.kmgames.model.dto.MonthlyTrafficDTO;
import ac.kmgames.model.mapper.MonthlyTrafficMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
final public class MonthlyTrafficService {

    private final MonthlyTrafficMapper monthlyTrafficMapper;

    public List<MonthlyTrafficDTO> getMonthlyTraffic(String endDate) {
        LocalDate endLocalDate = LocalDate.parse(endDate);
        LocalDate startLocalDate = endLocalDate.minusYears(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String startDates = startLocalDate.format(formatter);
        String endDates = endDate + " 23:59:59";
        return monthlyTrafficMapper.getMonthlyTraffic(startDates, endDates);
    }
}

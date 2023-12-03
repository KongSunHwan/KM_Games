package ac.kmgames.controller.restApi;

import ac.kmgames.model.dto.MonthlyTrafficDTO;
import ac.kmgames.service.MonthlyTrafficService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
@RestController
public class MonthlyTrafficRestController {

    final private MonthlyTrafficService monthlyTrafficService;
    @GetMapping("/api/monthly-traffic")
    public List<MonthlyTrafficDTO> getMonthlyTraffic(String endDate) {
        System.out.println("endDate : " + endDate);
        return monthlyTrafficService.getMonthlyTraffic(endDate);
    }

    @GetMapping("/api/monthlyRating")
    public List<?> getRatingTraffic() {
        return null;
    }

}

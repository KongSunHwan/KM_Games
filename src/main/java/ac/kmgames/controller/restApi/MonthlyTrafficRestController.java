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

    private MonthlyTrafficService monthlyTrafficService;
    @GetMapping("/api/monthly-traffic")
    public List<MonthlyTrafficDTO> getMonthlyTraffic() {
        List<MonthlyTrafficDTO> testData = new ArrayList<>();
        Random random = new Random();

        int currentYear = java.time.LocalDate.now().getYear();
        int currentMonth = java.time.LocalDate.now().getMonthValue();

        for (int i = 1; i <= 12; i++) {
            if (i < currentMonth) {
                MonthlyTrafficDTO entry = new MonthlyTrafficDTO();
                entry.setMonth(currentYear + "-" + (i < 10 ? "0" + i : i));
                entry.setGames(random.nextInt(500) + 500);
                entry.setMembers(random.nextInt(200) + 300);
                entry.setPlays(random.nextInt(10000) + 5000);
                entry.setSales(random.nextInt(50000) + 50000);

                testData.add(entry);
            }
        }

        return testData;
    }
}

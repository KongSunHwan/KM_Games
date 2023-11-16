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
        // 테스트를 위한 임의의 데이터 생성
        List<MonthlyTrafficDTO> testData = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= 12; i++) {
            MonthlyTrafficDTO entry = new MonthlyTrafficDTO();
            entry.setMonth("2023-" + (i < 10 ? "0" + i : i));
            entry.setGames(random.nextInt(500) + 500); // 500부터 1000까지의 임의의 값
            entry.setMembers(random.nextInt(200) + 300); // 300부터 500까지의 임의의 값
            entry.setPlays(random.nextInt(10000) + 5000); // 5000부터 15000까지의 임의의 값
            entry.setSales(random.nextInt(50000) + 50000); // 50000부터 100000까지의 임의의 값

            testData.add(entry);
        }

        return testData;
    }
}

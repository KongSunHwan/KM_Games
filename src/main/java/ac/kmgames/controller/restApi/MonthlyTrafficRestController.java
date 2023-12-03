package ac.kmgames.controller.restApi;

import ac.kmgames.model.dto.GameDataDTO;
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

    @GetMapping("/chart/data")
    public List<GameDataDTO> getPieChartData() {
        return generateTestData();
    }

    public List<GameDataDTO> generateTestData() {
        List<GameDataDTO> gameDataList = new ArrayList<>();
        gameDataList.add(new GameDataDTO("게임1", 50.5));
        gameDataList.add(new GameDataDTO("게임2", 25.5));
        gameDataList.add(new GameDataDTO("게임3", 10));
        gameDataList.add(new GameDataDTO("게임4", 5));
        gameDataList.add(new GameDataDTO("게임5", 9));
        return gameDataList;
    }


}

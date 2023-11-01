package ac.kmgames.model.dto;

import ac.kmgames.model.utils.PageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashMap;
import java.util.List;


public class ResponsePageDTO {
    @Data
    @AllArgsConstructor
    public static class ResponseUser {
        private List<UserDTO> userPageList;
        private PageDTO pageDTO;
    }

    @Data
    @AllArgsConstructor
    public static class ResponsePayment {
//        private List<PaymentHistoryDTO> paymentPageList;
        private List<HashMap> paymentPageList;
        private PageDTO pageDTO;
    }
    @Data
    @AllArgsConstructor
    public static class ResponseGame {
        private List<GameDTO> gamePageList;
        private PageDTO pageDTO;
    }
}

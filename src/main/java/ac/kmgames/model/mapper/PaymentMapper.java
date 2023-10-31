package ac.kmgames.model.mapper;

import ac.kmgames.model.dto.PaymentHistoryDTO;
import ac.kmgames.model.utils.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface PaymentMapper {

    List<PaymentHistoryDTO> getAllById(@Param("idx") int idx, @Param("cs") Criteria cs);

    int getCount(@Param("idx") int idx, @Param("cs") Criteria cs);

    List<HashMap> get_game_payment_l5(long id);
}

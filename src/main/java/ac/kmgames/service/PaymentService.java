package ac.kmgames.service;

import ac.kmgames.model.dto.ResponsePageDTO;
import ac.kmgames.model.entity.PaymentHistory;
import ac.kmgames.model.entity.User;
import ac.kmgames.model.mapper.PaymentMapper;
import ac.kmgames.model.repository.PaymentRepository;
import ac.kmgames.model.utils.Criteria;
import ac.kmgames.model.utils.PageDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
final public class PaymentService{
    private final PaymentRepository repository;
    private final PaymentMapper paymentMapper;

    public PaymentService(@Autowired PaymentRepository repository,
                          @Autowired PaymentMapper paymentMapper) {
        this.repository = repository;
        this.paymentMapper = paymentMapper;
    }

    public List<PaymentHistory> getAllByUserId(long id, int page){
        return repository.findAllByUserId(
            id,
            PageRequest.of(page, 20, Sort.by("id").descending())
        );
    }

    public int getCountByUserId(long id){
        return repository.countAllByUserId(id);
    }

    public List<PaymentHistory> findAllByUser(int page, User selectUser) {
        return repository.findAllByUser(selectUser);
    }

    public long getCount() {
        return repository.count();
    }

    public Page<PaymentHistory> getAll(int page){
        return repository.findAll(PageRequest.of(page, 5, Sort.by("id").descending()));
    }

    //admin user-paymentHistory 페이징
    public ResponsePageDTO.ResponsePayment getPaymentHListAdmin(int id, Criteria criteria) {
        Criteria cs = new Criteria(criteria.getPageNum(), criteria.getAmount(), criteria.getType(), criteria.getKeyword());
//        List<PaymentHistoryDTO> pageList = paymentMapper.getAllById(id, cs);
        List<HashMap> pageList = paymentMapper.getAllById(id, cs);

        log.info("pageList={}", pageList);
        int total = paymentMapper.getCount(id, cs);
        System.out.println("전체갯수 : " + total);
        PageDTO pageDTO = new PageDTO(cs,total);
        log.info("pageDTO={}", pageDTO);
        return new ResponsePageDTO.ResponsePayment(pageList, pageDTO);
    }

    public List<HashMap> get_game_payment_l5(long id) {
        return paymentMapper.get_game_payment_l5(id);
    }

    public ResponsePageDTO.ResponsePayment get_payment_group_game(Criteria criteria,long id) {
        Criteria cs = new Criteria(criteria.getPageNum(), criteria.getAmount(), criteria.getType(), criteria.getKeyword());
        List<HashMap> paymentPageList = paymentMapper.get_payment_group_game(cs,id);
        int total = paymentMapper.get_payment_group_game_cnt(cs,id);
        System.out.println(total);
        PageDTO pageDTO = new PageDTO(cs,total);
        System.out.println(paymentPageList);
        return new ResponsePageDTO.ResponsePayment(paymentPageList, pageDTO);
    }

    public int get_payment_group_game_cnt(Criteria cs,long id) {
        return paymentMapper.get_payment_group_game_cnt(cs,id);
    }
}

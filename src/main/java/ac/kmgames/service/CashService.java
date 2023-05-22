package ac.kmgames.service;

import ac.kmgames.model.repository.CashRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
final public class CashService{
    private final CashRepository cashRepository;

    public CashService(@Autowired CashRepository userRepository) {
        this.cashRepository = userRepository;
    }

    public CashRepository getRepo(){
        return cashRepository;
    }
}

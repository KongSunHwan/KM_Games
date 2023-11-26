package ac.kmgames.service;

import ac.kmgames.model.entity.CartItem;
import ac.kmgames.model.entity.ShoppingCart;
import ac.kmgames.model.repository.CartItemRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
public class CartItemService {

    private final CartItemRepository cartItemRepository;

    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }
}

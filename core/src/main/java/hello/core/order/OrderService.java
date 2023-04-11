package hello.core.order;

public interface OrderService {
    
    public Order createOrder(Long memberId, String itemName, int itemPrice);
    
}

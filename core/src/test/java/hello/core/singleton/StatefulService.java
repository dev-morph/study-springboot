package hello.core.singleton;

public class StatefulService {
    
    private int price; // 상태를 유지하는 필드
    
    //stateless하게 설계하기 위해서는 
    // privtae int price 주석처리하고, order가 price를 리턴하게 만들면 된다.
    // e.g.
    // public int order(string name, int price){
    //     return price;
    // }
    
    public void order(String name, int price){
        System.out.println("name = " + name + " price = " + price);
        this.price = price;
    }

    public int getPrice(){
        return price;
    }
}

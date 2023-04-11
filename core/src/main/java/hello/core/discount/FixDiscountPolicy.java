package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 할인

    @Override
    public int discount(Member member, int price) {
        //enum은 ==을 쓰는 것이 맞다!
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        }
        return 0;
    }
    
}

package hello.core.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    void vip_o() {
        //given
        Long memberId = 1L;
        Member member = new Member(memberId, "testA", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 10000);

        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){
                //given
                Long memberId = 2L;
                Member member = new Member(memberId, "memberBasic", Grade.BASIC);
        
                //when
                int discount = discountPolicy.discount(member, 10000);
        
                //then
                Assertions.assertThat(discount).isEqualTo(0);
    }
}

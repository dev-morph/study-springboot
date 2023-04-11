package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hello.core.AppConfig;

public class MemberServiceTest {

    MemberService memberService;
    
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void testJoin() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findmember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member.getName()).isEqualTo(findmember.getName());
    }
    @Test
    void testFindMember() {

    }

}

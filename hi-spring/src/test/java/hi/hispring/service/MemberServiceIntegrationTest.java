package hi.hispring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import hi.hispring.domain.Member;
import hi.hispring.repository.MemberRepository;
import hi.hispring.repository.MemoryMemberRepository;


// @Transactional 을 이용하여, DB에 영향을 줬던 것을 모두 다시 초기화 시킬 수 있다.
// 해당 어노테이션을 이용하면, Insert UPDATE DELETE Query가 있을 때, transaction을 Roll-back을 해준다.
@SpringBootTest
@Transactional
public class MemberServiceIntegrationTest {

    //어차피 테스트는 다른 곳에 쓰는 것도 아니고, 배포하지도 않으니, 가장 간편한 Field Injection 방식도 많이 쓴다.
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("MARK");
        //when
        Long savedId = memberService.join(member);
        //then
        Member result = memberService.findOne(savedId).get();
        assertThat(result.getName()).isEqualTo(member.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("mark1");
        Member member2 = new Member();
        member2.setName("mark1");
        //when

        memberService.join(member1);
        //then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재 하는 회원 입니다.");
        // try {
        //     memberService.join(member2);
        //     fail();
        // } catch (IllegalStateException e) {
        //     assertThat(e.getMessage()).isEqualTo("이미 존재 하는 회원 입니다!");
        // }
    }
}

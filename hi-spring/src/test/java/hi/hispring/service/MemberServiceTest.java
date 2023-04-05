package hi.hispring.service;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import hi.hispring.domain.Member;
import hi.hispring.repository.MemoryMemberRepository;

public class MemberServiceTest {

    public MemberService memberService;
    // store 변수가 static 이기 때문에, 새롭게 객체 생성해도 상관은 없지만, ... 결국 memberService에서 생성한 repository와 여기에서 생성한 repository는 다른 인스턴스이다!
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach(){
        memberRepository.clearStore();
    }


    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("mark1");
        //when
        Long savedId = memberService.join(member);
        //then
        Member result = memberService.findOne(savedId).get();
        assertThat(result).isEqualTo(member);
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

    @Test
    void testFindOne() {

    }

    @Test
    void testJoin() {

    }
}

package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {
    // 추상화에도 의존하면서 구현체에도 의존한다 -> DIP 위반!
    private final MemberRepository memberRepository;

    
    // (ac.getBean(MemberRepository.class))
    @Autowired 
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
    
    // 테스트용
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }
}

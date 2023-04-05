package hi.hispring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hi.hispring.domain.Member;
import hi.hispring.repository.MemberRepository;
import hi.hispring.repository.MemoryMemberRepository;


@Service
public class MemberService {
    
    //Test시, 같은 repository를 테스트 하기 위해서 아래처럼 바꿔준다.
    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    @Autowired
    MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * @param member
     * @return
     */
    public Long join(Member member){
        // 같은 이름이 있는 중복 회원 x 
        // 어차피 리턴 값이 Optional 이기 때문에 따로 저장하는 것이 아니라, 주석 아래처럼 람다식으로 한다. 
        // Optional<Member> result = memberRepository.findByName(member.getName());
        // result.ifPresent(m -> {
        //     throw new IllegalStateException("이미 존재 하는 회원 입니다.");
        // });
        validateDuplicateMember(member); // 중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
            .ifPresent(m -> {
                throw new IllegalStateException("이미 존재 하는 회원 입니다.");
            });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    /**
     * 
     */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }
}

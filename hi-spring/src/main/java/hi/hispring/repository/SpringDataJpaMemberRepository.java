package hi.hispring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import hi.hispring.domain.Member;

// 이렇게 JpaRepository를 extends 하고 있으면, SpringDataJpa가 자동으로 구현체를 만들어 준다.
// 그리고 자동으로 Bean에 등록도 해준다.
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {


    // 아래처럼 findByName으로 메소드를 만들게 되면,
    // JPQL로, select m from Member m where m.name = ? 으로 만든다.
    @Override
    Optional<Member> findByName(String name);
}

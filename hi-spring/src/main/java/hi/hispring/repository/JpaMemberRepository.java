package hi.hispring.repository;

import java.util.List;
import java.util.Optional;

import hi.hispring.domain.Member;
import jakarta.persistence.EntityManager;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    // PK를 이용해서 조회하는 방식은 findById 처럼 바로 사용 할 수 있지만, 그렇지 않은 칼럼을 이용할 때에는 아래처럼 query 짜야 한다.
    @Override
    public Optional<Member> findByName(String name) {
        List<Member> members = em.createQuery("select m from Member m where m.name = :name", Member.class)
                                    .setParameter("name", name)
                                    .getResultList();

        return members.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //jpql entity 대상으로 query를 날리는 것!
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

}

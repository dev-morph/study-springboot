package hi.hispring.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import hi.hispring.domain.Member;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach(){
        repository.clearStore();
    }

    @Test
    void testSave() {
        Member member = new Member();
        member.setName("mark");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    void testFindByName() {
        Member member1 = new Member();
        member1.setName("mark1");
        repository.save(member1);
        
        Member member2 = new Member();
        member2.setName("mark2");
        repository.save(member2);

        Member result = repository.findByName("mark1").get();

        assertThat(result).isEqualTo(member1);
        assertThat(result).isNotEqualTo(member2);
    }

    @Test
    void testFindById() {

    }

    @Test
    void testFindAll() {
        Member member1 = new Member();
        member1.setName("mark1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("mark2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }

}

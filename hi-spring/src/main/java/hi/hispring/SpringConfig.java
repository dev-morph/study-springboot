package hi.hispring;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import hi.hispring.aop.TimeTraceAop;
import hi.hispring.repository.JdbcMemberRepository;
import hi.hispring.repository.JdbcTemplateMemberRepository;
import hi.hispring.repository.JpaMemberRepository;
import hi.hispring.repository.MemberRepository;
import hi.hispring.repository.MemoryMemberRepository;
import hi.hispring.service.MemberService;
import jakarta.persistence.EntityManager;

@Configuration
public class SpringConfig {

  private final MemberRepository memberRepository;

  // DataSource dataSource;
  // EntityManager em;

  // @Autowired
  // public SpringConfig(DataSource dataSource, EntityManager em) {
  //   this.dataSource = dataSource;
  //   this.em = em;
  // }

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
        // return new MemberService(memberRepository());
    }

    @Bean
    public TimeTraceAop timeTraceAop(){
        return new TimeTraceAop();
    }

//     @Bean
//     public MemberRepository memberRepository() {
//       // return new MemoryMemberRepository();
//       // return new JdbcMemberRepository(dataSource);
//       // return new JdbcTemplateMemberRepository(dataSource);
//         return new JpaMemberRepository(em);
//     }
}

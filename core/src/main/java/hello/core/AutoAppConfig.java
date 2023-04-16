package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
    // basePackage를 따로 지정하지 않으면,
    // default는 AutoAppConfig가 있는 package, hello.core가 시작위치가 된다.
    // basePackages = "hello.core.member",
    excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

    // @Bean(name = "memoryMemberRepository")
    // MemberRepository memoryMemberRepository(){
    //     return new MemoryMemberRepository();
    // }
}

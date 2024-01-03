package hello.pcore;

import hello.pcore.discount.DiscountPolicy;
import hello.pcore.discount.FixDiscountPolicy;
import hello.pcore.discount.RateDiscountPolicy;
import hello.pcore.member.MemberRepository;
import hello.pcore.member.MemberService;
import hello.pcore.member.MemberServiceImpl;
import hello.pcore.member.MemoryMemberRepository;
import hello.pcore.order.OrderService;
import hello.pcore.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Config -> 설정정보를 당담한다는 뜻.
@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    private static DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }


//    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository());
//    }
//
//    public OrderService orderService(){
//        return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
//    }

}

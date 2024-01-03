package hello.pcore;

import hello.pcore.member.Grade;
import hello.pcore.member.Member;
import hello.pcore.member.MemberService;
import hello.pcore.member.MemberServiceImpl;
import hello.pcore.order.Order;
import hello.pcore.order.OrderService;
import hello.pcore.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

//        AppConfig appConfig=new AppConfig();
//        MemberService memberService =appConfig.memberService();
//        OrderService orderService=appConfig.orderService();


        ApplicationContext applicationContext=new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
         

        Long memberId=1L;
        Member member=new Member(memberId,"memeberA", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itemA",20000);

        System.out.println("order = "+order);

    }
}

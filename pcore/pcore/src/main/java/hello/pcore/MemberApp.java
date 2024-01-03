package hello.pcore;

import hello.pcore.member.Grade;
import hello.pcore.member.Member;
import hello.pcore.member.MemberService;
import hello.pcore.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

//        AppConfig appConfig=new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //AppConfig 안에 있는 환경설정을 가지고 스프링이 @Bean 어노테이션 붙어있는 것 관리.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findmember=memberService.findMember(1L);
        System.out.println("new member = "+member.getName());
        System.out.println("member = "+findmember.getName());

    }
}

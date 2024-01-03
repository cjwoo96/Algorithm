package hello.pcore.discount;

import hello.pcore.member.Member;

public interface DiscountPolicy {

    int discount(Member member, int price);



}

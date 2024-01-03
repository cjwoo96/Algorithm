package hello.pcore.discount;

import hello.pcore.member.Grade;
import hello.pcore.member.Member;

public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP)
        return 1000;
        else return 0;
    }
}

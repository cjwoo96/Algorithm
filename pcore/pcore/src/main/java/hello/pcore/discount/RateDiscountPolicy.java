package hello.pcore.discount;

import hello.pcore.member.Grade;
import hello.pcore.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{

    private final int DiscountPercent =10;

    @Override
    public int discount(Member member, int price) {
        if(member.getGrade()== Grade.VIP) {
            return price*DiscountPercent/100;
        }else return 0;
    }
}

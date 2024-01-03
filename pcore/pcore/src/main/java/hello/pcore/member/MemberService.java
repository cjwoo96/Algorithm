package hello.pcore.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long MemberId);
}

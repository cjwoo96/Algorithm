package hello.pcore.member;

public interface MemberRepository {
    void save(Member member);

    Member findById(Long MemberId);
}

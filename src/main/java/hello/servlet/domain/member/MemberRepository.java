package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    // 동시성 문제 때문에 실무에서는 ConcurrentHashMap 등을 써야 함
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    // 싱글톤으로 구성
    // 지금은 일단 스프링을 안 띄울 것이기 때문에 이와 같이 구성한다.
    private static final MemberRepository instance = new MemberRepository();

    // 싱글톤 인스턴스 반환
    public static MemberRepository getInstance() {
        return instance;
    }

    // 싱글톤을 위해 생성자 막기
    private MemberRepository() {}

    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id) {
        return store.get(id);
    }

    public List<Member> findAll() {
        // store 에 있는 value 리스트를 건들고 싶지 않아서 임
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        // store를 전부 날림
        store.clear();
    }
}

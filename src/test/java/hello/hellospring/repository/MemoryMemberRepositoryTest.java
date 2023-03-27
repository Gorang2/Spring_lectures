package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repo = new MemoryMemberRepository();

    @AfterEach // 각 test 이후 실행됨
    public void afterEach() {
        repo.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repo.save(member);
        // Optional에서 값 꺼내기
        Member result = repo.findById(member.getId()).get();
        Assertions.assertEquals(member, result);
    };

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");

        repo.save(member2);

        Member result = repo.findByName("spring1").get();
        Assertions.assertEquals(member1, result);

        result = repo.findByName("spring2").get();
        Assertions.assertEquals(member2, result);
    }

    @Test

    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repo.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");

        repo.save(member2);

        List<Member> result = repo.findAll();

        Assertions.assertEquals(2, result.size());
    }
}

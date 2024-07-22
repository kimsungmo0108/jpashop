package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)
@SpringBootTest
class MemberRepositoryTest {

  @Autowired MemberRepository memberRepository;

  @Test
  @Transactional
  @Rollback(false)
  public void testMember(){
    Member member = new Member();
    member.setName("memberA");

    Long savedId = memberRepository.save(member);
    Member findMember = memberRepository.find(savedId);

    Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
  }

}
package jpabook.jpashop.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

  @PersistenceContext
  private EntityManager em;

  public Long save(Member member){

    // insert
    // 컨텍스트에 저장을 하는거지 실제 쿼리문을 날리는게 아니다
    // jpa는 쿼리문을 한번에 날리기 때문에 컨텍스트에 저장하는 것이다
    // 커밋 명령어 : em.getTransaction().commit();
    em.persist(member);
    return member.getId();
  }


  public Member find(Long id){

    // select(찾고 싶은 자바 class, primary Key)
    return em.find(Member.class, id);
  }
}

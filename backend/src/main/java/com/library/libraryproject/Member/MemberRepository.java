package com.library.libraryproject.Member;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // o Spring gera o SQL a partir do nome do método
    List<Member> findByEmail(String email);
}
package com.library.libraryproject.Member;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository repository;

    public MemberService(MemberRepository repository) {
        this.repository = repository;
    }

    public List<Member> listAll() {
        return repository.findAll();
    }

    public Member findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Membro não encontrado: " + id));
    }

    @Transactional
    public Member create(Member member) {
        if (member.getEmail() == null || !member.getEmail().matches("^[A-Za-z0-9+_.-]+@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})$")) {
            throw new IllegalArgumentException("Email inválido.");
        }
        return repository.save(member);
    }
}
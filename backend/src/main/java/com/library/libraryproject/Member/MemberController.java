package com.library.libraryproject.Member;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberRepository repository;

    public MemberController(MemberRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Member> list() {
        return repository.findAll();
    }

    @PostMapping
    public Member create(@Valid @RequestBody Member member) {
        member.setId(null);
        return repository.save(member);
    }
}
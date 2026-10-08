package com.library.libraryproject.MemberBook;

import com.library.libraryproject.Book.Book;
import com.library.libraryproject.Member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member_book")
@Getter
@Setter
@NoArgsConstructor
public class MemberBook {

    @EmbeddedId
    private MemberBookID id;

    @ManyToOne
    @MapsId("memberId")
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @MapsId("bookId")
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "has_read", nullable = false)
    private boolean hasRead;
}
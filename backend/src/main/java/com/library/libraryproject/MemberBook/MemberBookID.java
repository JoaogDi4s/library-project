package com.library.libraryproject.MemberBook;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MemberBookID implements Serializable {

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "book_id")
    private Long bookId;
}
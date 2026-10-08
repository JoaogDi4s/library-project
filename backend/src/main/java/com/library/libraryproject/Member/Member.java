package com.library.libraryproject.Member;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "member")
@Getter 
@Setter 

@NoArgsConstructor

public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome não pode estar em branco")
    @Size(max = 100, message = "O nome não pode ter mais de 100 caracteres")
    @Column(nullable = false, length = 100)
    private String name;

    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "E-mail inválido")
    @Size(max = 100, message = "O email não pode ter mais de 100 caracteres")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotBlank(message = "O telefone não pode estar em branco")
    @Pattern(regexp = "^[0-9]{10,15}$", message = "O telefone deve ter entre 10 e 15 dígitos")
    @Column(nullable = false, length = 15)
    private String phone;
}
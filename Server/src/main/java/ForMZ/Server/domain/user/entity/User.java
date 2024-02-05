package ForMZ.Server.domain.user.entity;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer id;

    @Email
    @Column(nullable = false)
    private String email;

    @Valid
    @Column(nullable = false)
    private String password;

    @Column
    private String name;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column
    private String birthDate;

    public enum Gender{
        MALE,
        FEMALE
    }
}

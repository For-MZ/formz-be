package ForMZ.Server.domain.category.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private CategoryCode categoryCode;

    public enum CategoryCode{
        YOUTH_POLICY,
        YOUTH_SPACE,
        HAPPY_HOUSE,
        EMPLOYMENT,
        FOUNDED
    }
}

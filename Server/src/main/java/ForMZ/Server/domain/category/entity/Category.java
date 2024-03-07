package ForMZ.Server.domain.category.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    /**
     *  TODO: 추후 enum 형식 제거 후, String categoryName 으로 변경 후 data.sql 사용
     */
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private CategoryCode categoryCode;
}
package ForMZ.Server.domain.category.entity;

import ForMZ.Server.domain.category.exception.CategoryExceptionCode;
import ForMZ.Server.domain.category.exception.CategoryLogicException;
import com.fasterxml.jackson.annotation.JsonCreator;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

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

    public enum CategoryCode {
        POLICY, HOUSE, EMPLOYMENT, FOUNDED, FREEDOM, HONEYTIP;

        @JsonCreator
        public static CategoryCode parsing(String inputValue) {
            return Stream.of(CategoryCode.values())
                    .filter(categoryCode -> categoryCode.toString().equals(inputValue.toUpperCase()))
                    .findFirst()
                    .orElseThrow(() -> new CategoryLogicException(CategoryExceptionCode.INVALID_CATEGORY_CODE));
        }
    }
}
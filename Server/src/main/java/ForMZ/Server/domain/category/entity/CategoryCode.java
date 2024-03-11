package ForMZ.Server.domain.category.entity;

import ForMZ.Server.domain.category.exception.CategoryNotFoundException;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum CategoryCode {
    POLICY("정책"),
    HOUSE("주택"),
    EMPLOYMENT("취업"),
    FOUNDED("창업"),
    FREEDOM("자유"),
    HONEY_TIP("꿀팁");

    private String categoryName;

    CategoryCode(String categoryName){
        this.categoryName = categoryName;
    }

    /**
     * 대소문자 상관없이 해당 카테고리 코드가 존재하는지 확인
     */
    @JsonCreator
    public static CategoryCode parsing(String inputValue) {
        return Stream.of(CategoryCode.values())
                .filter(categoryCode -> categoryCode.toString().equals(inputValue.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new CategoryNotFoundException());
    }
}

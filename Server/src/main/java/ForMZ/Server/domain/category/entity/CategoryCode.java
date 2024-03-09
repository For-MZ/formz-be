package ForMZ.Server.domain.category.entity;

import ForMZ.Server.domain.category.exception.CategoryNotFoundException;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.stream.Stream;

public enum CategoryCode {
    POLICY, HOUSE, EMPLOYMENT, FOUNDED, FREEDOM, HONEYTIP;

    @JsonCreator
    public static CategoryCode parsing(String inputValue) {
        return Stream.of(CategoryCode.values())
                .filter(categoryCode -> categoryCode.toString().equals(inputValue.toUpperCase()))
                .findFirst()
                .orElseThrow(() -> new CategoryNotFoundException());
    }
}

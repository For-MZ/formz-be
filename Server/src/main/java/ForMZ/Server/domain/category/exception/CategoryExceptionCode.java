package ForMZ.Server.domain.category.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public enum CategoryExceptionCode {
    INVALID_CATEGORY_CODE(HttpStatus.BAD_REQUEST,"Invalid Category Code");

    @Getter
    private final HttpStatus httpStatus;

    @Getter
    private final String message;

    CategoryExceptionCode(HttpStatus httpStatus, String message){
        this.httpStatus = httpStatus;
        this.message = message;
    }
}

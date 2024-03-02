package ForMZ.Server.domain.post.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum PostExceptionList {
    POST_NOT_FOUND("E001", HttpStatus.NOT_FOUND, "존재하지 않는 게시물입니다.");

    private final String statusCode;
    private final HttpStatus httpStatus;
    private final String message;

}

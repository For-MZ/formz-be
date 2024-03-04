package ForMZ.Server.domain.comment.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum CommentExceptionList {
    COMMENT_NOT_FOUND("C003", HttpStatus.NOT_FOUND, "존재하지 않는 댓글입니다."),
    COMMENT_UPDATE_FAILED("C004", HttpStatus.BAD_REQUEST, "수정할 댓글 내용을 입력해주세요."),
    COMMENT_UNAUTHORIED("C005", HttpStatus.UNAUTHORIZED, "댓글 수정 권한이 없습니다.");

    private final String statusCode;
    private final HttpStatus httpStatus;
    private final String message;
}

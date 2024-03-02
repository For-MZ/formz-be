package ForMZ.Server.domain.comment.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class CommentConstant {

    @Getter
    @RequiredArgsConstructor
    public enum CResponseMessage {
        CREATE_SUCCESS("댓글이 성공적으로 작성되었습니다");

        private final String message;
    }
}
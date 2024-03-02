package ForMZ.Server.domain.comment.controller;

import ForMZ.Server.domain.comment.constant.CommentConstant;
import ForMZ.Server.domain.comment.dto.CommentReq;
import ForMZ.Server.domain.comment.service.CommentService;
import ForMZ.Server.global.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 작성
     */
    @PostMapping("/comments")
    public ResponseDto createComment(@RequestBody CommentReq commentReq) {
        commentService.createComment(commentReq);
        return ResponseDto.create("C001", CommentConstant.CResponseMessage.CREATE_SUCCESS.getMessage());
    }

}

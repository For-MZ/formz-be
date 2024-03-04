package ForMZ.Server.domain.comment.controller;

import ForMZ.Server.domain.comment.dto.AllCommentRes;
import ForMZ.Server.domain.comment.dto.CommentReq;
import ForMZ.Server.domain.comment.service.CommentService;
import ForMZ.Server.global.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static ForMZ.Server.domain.comment.constant.CommentConstant.CResponseMessage.CREATE_SUCCESS;
import static ForMZ.Server.domain.comment.constant.CommentConstant.CResponseMessage.GET_SUCCESS;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    /**
     * 댓글 작성
     */
    @PostMapping("/comments")
    public ResponseEntity<ResponseDto<?>> createComment(@RequestBody CommentReq commentReq) {
        commentService.createComment(commentReq);
        return ResponseEntity.ok(ResponseDto.create("C001", CREATE_SUCCESS.getMessage()));
    }

    /**
     * 댓글 조회
     */
    @GetMapping("/comments/all/{postId}")
    public ResponseEntity<ResponseDto<AllCommentRes>> getComments(@PathVariable(name = "postId") Long postId) {
        AllCommentRes comments = commentService.getComment(postId);
        return ResponseEntity.ok(ResponseDto.create("C001", GET_SUCCESS.getMessage(), comments));
    }
}

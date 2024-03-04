package ForMZ.Server.domain.comment.service;

import ForMZ.Server.domain.comment.dto.AllCommentRes;
import ForMZ.Server.domain.comment.dto.CommentReq;
import ForMZ.Server.domain.comment.dto.CommentRes;
import ForMZ.Server.domain.comment.entity.Comment;

public interface CommentService {
    void createComment(CommentReq commentReq);

    AllCommentRes getComment(Long postId);
}

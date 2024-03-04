package ForMZ.Server.domain.comment.service;

import ForMZ.Server.domain.comment.dto.*;
import ForMZ.Server.domain.comment.entity.Comment;

public interface CommentService {
    void createComment(CommentReq commentReq);

    AllCommentRes getComment(Long postId);

    CommentUpdateRes updateComment(Long commentId, CommentUpdateReq cmtUpdateReq);
}

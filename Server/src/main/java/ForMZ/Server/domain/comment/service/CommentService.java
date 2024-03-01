package ForMZ.Server.domain.comment.service;

import ForMZ.Server.domain.comment.dto.CommentReq;

public interface CommentService {
    void createComment(CommentReq commentReq);
}

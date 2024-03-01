package ForMZ.Server.domain.comment.service;

import ForMZ.Server.domain.comment.dto.CommentReq;
import ForMZ.Server.domain.comment.entity.Comment;
import ForMZ.Server.domain.post.entity.Post;
import ForMZ.Server.domain.post.service.PostService;
import ForMZ.Server.domain.user.entity.User;
import ForMZ.Server.domain.user.service.UserService;
import ForMZ.Server.domain.user.service.UserServiceImp;
import ForMZ.Server.global.common.ResponseDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImp implements CommentService{

    private final UserService userService;
    private final PostService postService;

    /**
     * 댓글 작성
     */
    @Override
    public void createComment(CommentReq commentReq) {
        Post post = postService.getPost(commentReq.getPostId());
        User user = userService.getUser(commentReq.getUserId());

        final String content = commentReq.getComment();
        Comment newComment = new Comment(content, user, post);
    }
}

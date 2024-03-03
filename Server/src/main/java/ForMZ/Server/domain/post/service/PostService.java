package ForMZ.Server.domain.post.service;

import ForMZ.Server.domain.post.dto.PostReq;
import ForMZ.Server.domain.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface PostService {
    Post createPost(PostReq postReq);
    Post getPost(Long postId);
    Post updatePost(PostReq postReq, Long postId);
}
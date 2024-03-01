package ForMZ.Server.domain.post.service;

import ForMZ.Server.domain.post.entity.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

public interface PostService {
    Post getPost(Long postId);
}

package ForMZ.Server.domain.post.service;

import ForMZ.Server.domain.post.dto.PostReq;
import ForMZ.Server.domain.post.entity.Post;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    Post getPost(Long postId);
    Post updatePost(Post post, Long postId);
    void deletePost(Long postId);
    Page<Post> getPosts(String sortParam, int page, int size);
}

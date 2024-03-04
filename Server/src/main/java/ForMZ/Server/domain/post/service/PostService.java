package ForMZ.Server.domain.post.service;

import ForMZ.Server.domain.post.dto.PostReq;
import ForMZ.Server.domain.post.entity.Post;

import java.util.List;

public interface PostService {
    Post createPost(PostReq postReq);
    Post getPost(Long postId);
    Post updatePost(PostReq postReq, Long postId);
    void deletePost(Long postId);
    List<Post> getPosts(String sortParam);
}
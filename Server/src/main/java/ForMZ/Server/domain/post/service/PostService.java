package ForMZ.Server.domain.post.service;

import ForMZ.Server.domain.post.dto.AllPostRes;
import ForMZ.Server.domain.post.dto.PostReq;
import ForMZ.Server.domain.post.dto.PostRes;
import ForMZ.Server.domain.post.dto.PostUpdateReq;
import ForMZ.Server.domain.post.entity.Post;

public interface PostService {
    void createPost(PostReq postReq);
    Post getPost(Long postId);
    Post updatePost(PostUpdateReq postUpdateReq, Long postId);
    void deletePost(Long postId);
    AllPostRes getPosts(String sort, String categoryCode, int page, int size);
    PostRes convertPostRes(Post post);
    void viewPlus(Post post);
}

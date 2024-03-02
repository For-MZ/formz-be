package ForMZ.Server.domain.post.service;

import ForMZ.Server.domain.post.entity.Post;
import ForMZ.Server.domain.post.exception.PostNotFoundException;
import ForMZ.Server.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {

    private final PostRepository postRepository;
    @Override
    public Post getPost(Long postId) {
        Post post =  postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);
        return post;
    }
}

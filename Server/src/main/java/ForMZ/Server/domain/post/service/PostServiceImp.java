package ForMZ.Server.domain.post.service;

import ForMZ.Server.domain.post.dto.PostReq;
import ForMZ.Server.domain.post.entity.Post;
import ForMZ.Server.domain.post.mapper.PostMapper;
import ForMZ.Server.domain.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {

    private final PostMapper mapper;
    private final PostRepository postRepository;
    @Override
    public Post createPost(PostReq postReq){
        Post post = mapper.postReqToPost(postReq);
        return postRepository.save(post);
    }
    @Override
    public Post getPost(Long postId) {
        Post post =  postRepository.findById(postId)
                .orElseThrow();
        return post;
    }

    @Override
    public Post updatePost(PostReq postReq, Long postId){
        Post post = getPost(postId);
        Post modPost = mapper.postReqToPost(postReq);

        editField(modPost::getCategory, post::setCategory);
        editField(modPost::getTitle, post::setTitle);
        editField(modPost::getContent, post::setContent);

        return postRepository.save(post);
    }

    private <T> void editField(Supplier<T> supplier, Consumer<T> consumer) {
        Optional.ofNullable(supplier.get()).ifPresentOrElse(consumer, () -> consumer.accept(null));
    }
}
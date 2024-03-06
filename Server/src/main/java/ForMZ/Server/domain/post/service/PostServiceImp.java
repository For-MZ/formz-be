package ForMZ.Server.domain.post.service;

import ForMZ.Server.domain.post.dto.PostReq;
import ForMZ.Server.domain.post.entity.Post;
import ForMZ.Server.domain.post.mapper.PostMapper;
import ForMZ.Server.domain.post.repository.PostRepository;
import ForMZ.Server.global.entity.BaseEntity;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class PostServiceImp implements PostService {

    private final PostRepository postRepository;

    @Override
    @Transactional
    public Post createPost(Post post){
        return postRepository.save(post);
    }

    @Override
    public Post getPost(Long postId) {
        Post post =  postRepository.findById(postId)
                .orElseThrow();     //TODO: NOT_FOUND_POST exception
        /**
         * isDeleted를 따로 만들지 말고 getPost 내부로 옮길지
         */
        isDeleted(post);
        return post;
    }

    @Override
    @Transactional
    public Post updatePost(Post modPost, Long postId){
        Post post = getPost(postId);
        verifyPostAuthority(post);

        editField(modPost::getCategory, post::setCategory);
        editField(modPost::getTitle, post::setTitle);
        editField(modPost::getContent, post::setContent);

        return postRepository.save(post);
    }

    @Override
    @Transactional
    public void deletePost(Long postId){
        Post post = getPost(postId);
        verifyPostAuthority(post);
        post.setObjectState(BaseEntity.ObjectState.DEL);
    }

    @Override
    public Page<Post> getPosts(String sortParam, int page, int size){   // sortParam : 정렬 기준
        // TODO: sortParam에 맞는 정렬 작업
        return postRepository.findAll(PageRequest.of(page, size,
                Sort.by("createdDate").descending()));
    }

    /**
     * 현재 사용자가 해당 POST에 대한 권한을 가지고 있는지 확인
     */
    private void verifyPostAuthority(Post post){
        Long userId = 0L;   // TODO: 현재 사용자 id 가져오는 메서드
                            // post.userId 와 현재 userId 값을 비교. 같지 않을 시 UNAUTHORIZED_POST_ACCESS exception
    }

    /**
     * 삭제된 상태의 POST인지 확인
     */
    private void isDeleted(Post post){
        if(post.getObjectState() == BaseEntity.ObjectState.DEL)
            throw new RuntimeException();   // TODO: NOT_FOUND_POST exception
    }

    private <T> void editField(Supplier<T> supplier, Consumer<T> consumer) {
        Optional.ofNullable(supplier.get()).ifPresentOrElse(consumer, () -> consumer.accept(null));
    }
}
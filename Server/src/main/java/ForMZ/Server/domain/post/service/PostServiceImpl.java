package ForMZ.Server.domain.post.service;

import ForMZ.Server.domain.bookmark.entity.Bookmark;
import ForMZ.Server.domain.bookmark.repository.BookmarkRepository;
import ForMZ.Server.domain.post.dto.PostRes;
import ForMZ.Server.domain.post.entity.Post;
import ForMZ.Server.domain.post.exception.InvalidSortParamException;
import ForMZ.Server.domain.post.exception.PostNotFoundException;
import ForMZ.Server.domain.post.exception.UnauthorizedPostAccessException;
import ForMZ.Server.domain.post.mapper.PostMapper;
import ForMZ.Server.domain.post.repository.PostRepository;
import ForMZ.Server.domain.postLike.entity.PostLike;
import ForMZ.Server.domain.postLike.repository.PostLikeRepository;
import ForMZ.Server.domain.user.entity.User;
import ForMZ.Server.domain.user.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static ForMZ.Server.global.entity.BaseEntity.ObjectState.*;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final BookmarkRepository bookmarkRepository;
    private final PostLikeRepository postLikeRepository;
    private final UserService userService;
    private final PostMapper mapper;

    /**
     *  POST 생성
     */
    @Override
    @Transactional
    public void createPost(Post post){
        postRepository.save(post);
    }

    /**
     *  1개의 POST 조회
     */
    @Override
    public Post getPost(Long postId) {
        Post post =  postRepository.findById(postId)
                .orElseThrow(PostNotFoundException::new);

        if(post.getObjectState() == DEL)
            throw new PostNotFoundException();
        return post;
    }

    /**
     *  POST 수정
     */
    @Override
    @Transactional
    public Post updatePost(Post modPost, Long postId){
        Post post = getPost(postId);
        verifyPostAuthority(post);

//        TODO : Entity Setter 삭제 후 변경 로직 메서드 엔티티 내부로 이동시키기
//        editField(modPost::getCategory, post::setCategory);
//        editField(modPost::getTitle, post::setTitle);
//        editField(modPost::getContent, post::setContent);

        return postRepository.save(post);
    }

    /**
     *  POST 삭제
     */
    @Override
    @Transactional
    public void deletePost(Long postId){
        Post post = getPost(postId);
        verifyPostAuthority(post);
        post.changeState(DEL);
    }

    /**
     *  모든 POST 조회
     */
    @Override
    public Page<Post> getPosts(String sortParam, String category, int page, int size){
        // TODO : 카테고리 필터링
        switch (sortParam){
            case "createdDate" :
                return postRepository.findAll(PageRequest.of(page, size,
                        Sort.by("createdDate").descending()));
            case "likeCnt":     // TODO : 좋아요수 기준 정렬
            case "view":
                return postRepository.findAll(PageRequest.of(page, size,
                        Sort.by("view").descending()));
            case "commentCnt":  // TODO : 댓글수 기준 정렬
        }
        throw new InvalidSortParamException();
    }

    /**
     *  POST -> POST_RES 변경해주는 메서드
     */
    public PostRes convertPostRes(Post post){
        Long userId = 0L;   // TODO: 리프레시 토큰에서 현재 사용자 id 가져오는 메서드
        User user = userService.getUser(userId);

        boolean bookmarked = checkUsersBookmarkedPost(post, user);
        boolean liked = checkUsersPostLike(post, user);
        /**
         *  REFACTORING CONSIDER : 북마크와 좋아요 확인 User.postLike, User.bookmark 에서 찾는게 나은지, 각각의 Repository에서 찾는게 나은지
         */

        int likeCnt = post.getPostLikes().size();
        return mapper.postToPostRes(post, bookmarked, liked, likeCnt);
    }

    /**
     *  현재 유저가 북마크한 POST인지 확인
     */
    private boolean checkUsersBookmarkedPost(Post post, User user) {
        Optional<Bookmark> bookmark = bookmarkRepository.findByUserAndPost(user, post);
        if(bookmark.isPresent()){
            return true;
        }
        return false;
    }

    /**
     *  현재 유저가 좋아요 누른 POST인지 확인
     */
    private boolean checkUsersPostLike(Post post, User user) {
        Optional<PostLike> postLike = postLikeRepository.findByUserAndPost(user, post);
        if(postLike.isPresent()){
            return true;
        }
        return false;
    }

    /**
     *  현재 사용자가 해당 POST에 대한 권한을 가지고 있는지 확인
     */
    private void verifyPostAuthority(Post post){
        Long userId = 0L;   // TODO: 리프레시 토큰에서 현재 사용자 id 가져오는 메서드
        if(!post.getUser().getId().equals(userId)){
            throw new UnauthorizedPostAccessException();
        }
    }



    private <T> void editField(Supplier<T> supplier, Consumer<T> consumer) {
        Optional.ofNullable(supplier.get()).ifPresentOrElse(consumer, () -> consumer.accept(null));
    }
}

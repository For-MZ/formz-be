package ForMZ.Server.domain.post.controller;

import ForMZ.Server.domain.post.dto.PostReq;
import ForMZ.Server.domain.post.dto.PostRes;
import ForMZ.Server.domain.post.entity.Post;
import ForMZ.Server.domain.post.mapper.PostMapper;
import ForMZ.Server.domain.post.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@Validated
@RequestMapping("/community")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PostController {

    private final PostMapper mapper;
    private final PostService postService;

    /**
     *  게시글 작성
     */
    @PostMapping("/posts")
    public ResponseEntity createPost(@RequestBody PostReq postReq){
        Post post = postService.createPost(mapper.postReqToPost(postReq));
        PostRes response = mapper.postToPostRes(post);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    /**
     *  게시글 수정
     */
    @PatchMapping("/posts/{post-id}")
    public ResponseEntity updatePost(@RequestBody PostReq postReq,
                                     @PathVariable("post-id") Long postId){
        Post post = postService.updatePost(mapper.postReqToPost(postReq), postId);
        PostRes response = mapper.postToPostRes(post);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     *  게시글 삭제
     */
    @DeleteMapping("/posts/{post-id}")
    public ResponseEntity deletePost(@PathVariable("post-id") Long postId){
        postService.deletePost(postId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    /**
     *  게시글 목록 조회
     */
    @GetMapping("/posts")
    public ResponseEntity getPostList(@RequestParam(name = "page", defaultValue = "1", required = false) int page,
                                      @RequestParam(name = "pageSize", defaultValue = "10", required = false) int pageSize,
                                      @RequestParam(name = "category", required = false) String category){
        String sortParam = "";  // TODO: 정렬 기준 파라미터 "sortParam"
        List<Post> postList = postService.getPosts(sortParam);
        List<PostRes> postResList = mapper.postListToPostResList(postList);
        return new ResponseEntity(postResList, HttpStatus.OK);
    }
}

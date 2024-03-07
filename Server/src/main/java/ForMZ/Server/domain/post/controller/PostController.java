package ForMZ.Server.domain.post.controller;


import ForMZ.Server.domain.post.dto.PostReq;
import ForMZ.Server.domain.post.dto.PostRes;
import ForMZ.Server.domain.post.entity.Post;
import ForMZ.Server.domain.post.mapper.PostMapper;
import ForMZ.Server.domain.post.service.PostService;
import ForMZ.Server.global.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static ForMZ.Server.domain.post.constant.PostConstant.PostResponseMessage.*;

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
        PostRes response = postService.convertPostRes(post);
        return new ResponseEntity(ResponseDto.create(201, CREATE_POST_SUCCESS.getMessage(), response), HttpStatus.CREATED);
    }

    /**
     *  게시글 수정
     */
    @PatchMapping("/posts/{postId}")
    public ResponseEntity updatePost(@RequestBody PostReq postReq,
                                     @PathVariable("postId") Long postId){
        Post post = postService.updatePost(mapper.postReqToPost(postReq), postId);
        PostRes response = postService.convertPostRes(post);
        return new ResponseEntity(ResponseDto.create(200, UPDATE_POST_SUCCESS.getMessage(), response), HttpStatus.OK);
    }

    /**
     *  게시글 삭제
     */
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity deletePost(@PathVariable("postId") Long postId){
        postService.deletePost(postId);
        return new ResponseEntity(ResponseDto.create(204, DELETE_POST_SUCCESS.getMessage()),HttpStatus.NO_CONTENT);
    }

    /**
     *  게시글 목록 조회
     */
    @GetMapping("/posts")
    public ResponseEntity checkPostList(@RequestParam(name = "page", defaultValue = "1", required = false) int page,
                                      @RequestParam(name = "pageSize", defaultValue = "10", required = false) int size,
                                      @RequestParam(name = "category", required = false) String category){
        String sortParam = "";  // TODO: 정렬 기준 파라미터 "sortParam"
        Page<Post> postList = postService.getPosts(sortParam, page-1, size);
        List<PostRes> postResList = mapper.postListToPostResList(postList.getContent());
        return new ResponseEntity(ResponseDto.create(200, GET_POSTS_SUCCESS.getMessage(), postResList), HttpStatus.OK);
    }

//    /**
//     *  TODO : 특정 게시글 개별 조회
//     */
//    @GetMapping("/posts/{postId}")
//    public ResponseEntity checkPost(@PathVariable("postId") Long postId){
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
}

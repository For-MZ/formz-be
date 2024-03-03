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

@RestController
@Slf4j
@Validated
@RequestMapping("/community")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class PostController {

    private final PostMapper mapper;
    private final PostService postService;

    @PostMapping("/posts")
    public ResponseEntity createPost(@RequestBody PostReq postReq){
        Post post = postService.createPost(postReq);
        PostRes response = mapper.postToPostRes(post);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PatchMapping("/posts/{post-id}")
    public ResponseEntity updatePost(@RequestBody PostReq postReq,
                                     @PathVariable("post-id") Long postId){
        Post post = postService.updatePost(postReq, postId);
        PostRes response = mapper.postToPostRes(post);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

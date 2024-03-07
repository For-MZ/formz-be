package ForMZ.Server.domain.post.mapper;

import ForMZ.Server.domain.comment.mapper.CommentMapper;
import ForMZ.Server.domain.post.dto.PostReq;
import ForMZ.Server.domain.post.dto.PostRes;
import ForMZ.Server.domain.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = CommentMapper.class)
public interface PostMapper {
    @Mapping(source = "postReq.category", target = "category.categoryCode")
    Post postReqToPost(PostReq postReq);

    @Mapping(source = "post.id", target = "postId")
    @Mapping(source = "post.content", target = "content")
    @Mapping(source = "post.user.nickName", target = "writer")
    @Mapping(source = "post.category.categoryCode", target = "category")
    @Mapping(source = "bookmarked", target = "bookmarked")
    @Mapping(source = "liked", target = "liked")
    @Mapping(source = "likeCnt", target = "likeCnt")
    PostRes postToPostRes(Post post, boolean bookmarked, boolean liked, int likeCnt);

    List<PostRes> postListToPostResList(List<Post> posts);
}

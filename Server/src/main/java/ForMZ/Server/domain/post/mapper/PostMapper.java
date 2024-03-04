package ForMZ.Server.domain.post.mapper;

import ForMZ.Server.domain.post.dto.PostReq;
import ForMZ.Server.domain.post.dto.PostRes;
import ForMZ.Server.domain.post.entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PostMapper {
    @Mapping(source = "postReq.category", target = "category.categoryCode")
    Post postReqToPost(PostReq postReq);

    @Mapping(source = "post.id", target = "postId")
    PostRes postToPostRes(Post post);
    List<PostRes> postListToPostResList(List<Post> posts);
}

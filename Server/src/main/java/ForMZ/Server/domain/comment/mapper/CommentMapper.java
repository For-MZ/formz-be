package ForMZ.Server.domain.comment.mapper;

import ForMZ.Server.domain.comment.dto.CommentRes;
import ForMZ.Server.domain.comment.dto.child.ChildCommentRes;
import ForMZ.Server.domain.comment.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper
public interface CommentMapper {

    CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

    @Mapping(source = "comment.content", target = "comment")
    @Mapping(source = "comment.user.nickName", target = "cmtWriter")
    CommentRes toCommentRes(boolean cmtLiked, int cmtLikeCnt,
                            List<ChildCommentRes> childCmts, Comment comment);

    @Mapping(source = "comment.content", target = "comment")
    @Mapping(source = "comment.user.nickName", target = "cmtWriter")
    ChildCommentRes toChildCommentRes(boolean cmtLiked, int cmtLikeCnt, Comment comment);
}

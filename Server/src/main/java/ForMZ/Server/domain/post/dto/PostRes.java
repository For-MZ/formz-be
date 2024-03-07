package ForMZ.Server.domain.post.dto;

import ForMZ.Server.domain.category.entity.Category;
import ForMZ.Server.domain.comment.dto.AllCommentRes;
import ForMZ.Server.domain.post.entity.Content;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostRes {
    private int postId;
    private String title;
    private Content content;
    private String writer;
    private Category category;
    private boolean bookmarked;
    private boolean liked;
    private int likeCnt;
    private int viewCnt;
    private int commentCnt;
    private AllCommentRes comments;
}

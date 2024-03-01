package ForMZ.Server.domain.comment.dto;


import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentReq {
    Long postId;

    Long userId;

    @Valid()
    String comment;

}

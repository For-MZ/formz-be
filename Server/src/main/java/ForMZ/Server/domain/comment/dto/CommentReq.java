package ForMZ.Server.domain.comment.dto;


import jakarta.validation.Valid;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CommentReq {
    Long postId;

    Long userId;

    @Valid()
    String comment;

}

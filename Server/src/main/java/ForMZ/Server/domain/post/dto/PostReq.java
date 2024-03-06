package ForMZ.Server.domain.post.dto;

import ForMZ.Server.domain.category.entity.CategoryCode;
import ForMZ.Server.domain.post.entity.Content;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostReq {

    @NotNull
    private CategoryCode category;
    @NotNull
    private String title;
    @NotNull
    private Content content;
}

package ForMZ.Server.domain.post.dto;

import ForMZ.Server.domain.category.entity.CategoryCode;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostReq {

    @NotBlank
    private String title;

    private String text;

    private String imageUrl;
}

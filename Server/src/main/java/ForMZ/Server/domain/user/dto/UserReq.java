package ForMZ.Server.domain.user.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserReq {
    @Email  // TODO: 추후 정규표현식으로 변경
    private String email;
    @Valid
    private String nickName;
    @Valid
    private String password;

    private String profileImage;
}

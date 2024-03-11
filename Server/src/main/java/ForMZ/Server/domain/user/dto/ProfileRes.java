package ForMZ.Server.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRes {
    private Long userId;
    private String email;
    private String nickName;
    private String profileImage;
}

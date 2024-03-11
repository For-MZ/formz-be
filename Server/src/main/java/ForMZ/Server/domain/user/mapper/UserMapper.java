package ForMZ.Server.domain.user.mapper;

import ForMZ.Server.domain.user.dto.ProfileRes;
import ForMZ.Server.domain.user.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    ProfileRes userToProfileRes(User user);
}

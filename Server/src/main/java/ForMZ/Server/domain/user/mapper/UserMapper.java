package ForMZ.Server.domain.user.mapper;

import ForMZ.Server.domain.user.dto.ProfileRes;
import ForMZ.Server.domain.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(source = "user.profileImage.fileUrl", target = "profileImage")
    ProfileRes userToProfileRes(User user);
}

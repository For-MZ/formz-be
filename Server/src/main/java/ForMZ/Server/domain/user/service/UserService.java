package ForMZ.Server.domain.user.service;

import ForMZ.Server.domain.user.entity.User;

public interface UserService {
    User getUser(Long userId);
    User getCurrentUser();
}

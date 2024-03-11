package ForMZ.Server.domain.user.service;

import ForMZ.Server.domain.user.entity.User;
import ForMZ.Server.domain.user.exception.UserNotFoundException;
import ForMZ.Server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    /**
     * UserId를 통한 유저 조회
     */
    @Override
    public User getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
        return user;
    }

    /**
     * 현재 접속 중인 유저 정보 가져오기
     */
    public User getCurrentUser() {
        Long userId = 0L;   // TODO : 현재 유저 ID 가져오기
        return getUser(userId);
    }
}

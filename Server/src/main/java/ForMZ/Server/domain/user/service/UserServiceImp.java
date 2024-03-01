package ForMZ.Server.domain.user.service;

import ForMZ.Server.domain.user.entity.User;
import ForMZ.Server.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        return user;
    }
  
}
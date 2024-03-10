package ForMZ.Server.global.auth.jwt.service;

import ForMZ.Server.domain.user.entity.User;
import ForMZ.Server.domain.user.exception.UserNotFoundException;
import ForMZ.Server.domain.user.repository.UserRepository;
import ForMZ.Server.global.auth.jwt.dto.PrincipalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        System.out.println("PrincipalDetailsService");
        System.out.println("Login");
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UserNotFoundException());;
        return null;
                //new PrincipalDetails(user);
    }
}

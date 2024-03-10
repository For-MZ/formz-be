package ForMZ.Server.domain.user.controller;

import ForMZ.Server.domain.post.dto.PostReq;
import ForMZ.Server.global.common.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static ForMZ.Server.domain.post.constant.PostConstant.PostResponseMessage.CREATE_POST_SUCCESS;

@RestController
@RequiredArgsConstructor
public class UserController {

    // Spring security 무한 redirection 방지용 임시 login controller
    @RequestMapping("/login")
    public ResponseEntity login(){

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @RequestMapping("/login/oauth")
    public ResponseEntity loginOauth(){

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

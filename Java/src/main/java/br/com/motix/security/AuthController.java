package br.com.motix.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authManager;

    public AuthController(AuthenticationManager authManager) {
        this.authManager = authManager;
    }

//    @PostMapping("/login")
//    public Map<String, String> login(@RequestBody Map<String, String> body) {
//        Authentication auth = authManager.authenticate(
//                new UsernamePasswordAuthenticationToken(body.get("username"), body.get("password")));
//        // gere o JWT aqui e retorne (omiti para focar no erro do bean)
//        return Map.of("status", "ok");
//    }
}




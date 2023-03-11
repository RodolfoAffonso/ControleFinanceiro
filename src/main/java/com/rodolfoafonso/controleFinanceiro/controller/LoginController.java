package com.rodolfoafonso.controleFinanceiro.controller;

import com.rodolfoafonso.controleFinanceiro.dto.UserLoginDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.stream.Collectors;

@AllArgsConstructor
@RequestMapping("/login")
@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JwtEncoder jwtEncoder;

    @PostMapping
    public ResponseEntity login(@RequestBody UserLoginDTO login){
        Authentication authenticate = authenticationManager
                 .authenticate(
                        new UsernamePasswordAuthenticationToken(
                                login.getUser(), login.getPassword()
                        )
                );

        String name = authenticate.getName();


        String scope = authenticate.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(" "));

        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("ControleFinanceiiro")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(36000L))
                .subject(name)
                .claim("roles", scope)
                .build();

        String token = this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(token);
    }
}

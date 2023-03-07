package com.rodolfoafonso.controleFinanceiro.service;

import com.rodolfoafonso.controleFinanceiro.ControleFinanceiroApplication;
import com.rodolfoafonso.controleFinanceiro.entity.User;
import com.rodolfoafonso.controleFinanceiro.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class LoginService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void createUsers(){
        User user2 = this.userRepository.findByUsername("user2").orElse(User.builder().username("user2").build());
        user2.changePassword(this.passwordEncoder.encode("password2"));

        this.userRepository.save(user2);

    }
}

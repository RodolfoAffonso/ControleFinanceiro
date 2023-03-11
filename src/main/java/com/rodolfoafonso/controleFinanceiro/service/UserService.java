package com.rodolfoafonso.controleFinanceiro.service;

import com.rodolfoafonso.controleFinanceiro.dto.UserLoginDTO;
import com.rodolfoafonso.controleFinanceiro.entity.User;
import com.rodolfoafonso.controleFinanceiro.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository ;
    private final PasswordEncoder passwordEncoder;



    public void incluir(UserLoginDTO user) {
        User user1 = this.userRepository.findByUsername(user.getUser()).orElse(User.builder().username(user.getUser()).build());
        user1.changePassword(this.passwordEncoder.encode(user.getPassword()));

        userRepository.save(user1);

    }
}

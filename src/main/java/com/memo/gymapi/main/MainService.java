package com.memo.gymapi.main;

import com.memo.gymapi.jwt.JwtService;
import com.memo.gymapi.user.User;
import com.memo.gymapi.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
@RequiredArgsConstructor
public class MainService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    public void fillModel(Model model, String jwt){

        User user = userRepository.findByUsername(jwtService.getUsernameFromToken(jwt)).orElseThrow();

        model.addAttribute("firstName", user.getFirstname());
        model.addAttribute("lastName", user.getLastname());
        model.addAttribute("country", user.getCountry());
        model.addAttribute("rfc", user.getRfc());
    }

}

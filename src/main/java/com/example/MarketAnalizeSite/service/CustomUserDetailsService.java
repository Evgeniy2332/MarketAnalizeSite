package com.example.MarketAnalizeSite.service;

import com.example.MarketAnalizeSite.models.users.User;
import com.example.MarketAnalizeSite.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("Пользователь не найден");
        }
        if (!user.isActive()) { // Проверяем, активен ли пользователь
            throw new DisabledException("Учетная запись пользователя деактивирована");
        }
        // Увеличиваем счетчик входов, если пользователь активен
        user.setLoginCount(user.getLoginCount() + 1);
        userRepo.save(user);
        return user;
    }
}

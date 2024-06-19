package com.stock_manager.stock_manager.security.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stock_manager.stock_manager.model.Seller;
import com.stock_manager.stock_manager.repository.SellerRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Log4j2
public class AuthorizationService implements UserDetailsService {

    private final SellerRepository sellerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUser(username);
    }

    private UserDetails getUser(String username) {
        Optional<Seller> userSeller = sellerRepository.findByEmail(username);

        if (userSeller.isPresent()) {
            log.info("username encontrado {}", userSeller.get().getEmail());
            return userSeller.get();
        }
        throw new UsernameNotFoundException("Usuário não encontrado");
    }
}

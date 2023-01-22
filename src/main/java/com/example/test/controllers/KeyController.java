package com.example.test.controllers;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.adapters.spi.KeycloakAccount;
import org.keycloak.authorization.identity.Identity;
import org.keycloak.representations.JsonWebToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class KeyController {
    KeycloakAccount keycloakAccount;
    Identity identity;
    UserDetails userDetails;
    JsonWebToken token;

    @GetMapping("/test")
    public String testController() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        log.info(username);
        String user2= userDetails.getUsername();
        log.info(user2);
       //String name= keycloakAccount.getPrincipal().getName();
        return "Test";
    }
}

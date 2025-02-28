package com.example.backend.controller.Login;

import com.example.backend.dto.request.LoginDTO;
import com.example.backend.dto.response.ResponseData;
import com.example.backend.model.User;
import com.example.backend.service.LoginService;
import com.example.backend.util.JwtUtilHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private JwtUtilHelper jwtUtilHelper;

    @GetMapping
    public ResponseEntity<Void> showLogin() {
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("/login.html"))
                .build();
    }


    @PostMapping()
    ResponseEntity<?> signin(@RequestBody LoginDTO request) {
        ResponseData responseData = new ResponseData();

        /*
         * Lấy key
         * SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
         * String encrypKey = Encoders.BASE64.encode(secretKey.getEncoded());
         * System.out.println(encrypKey);
         */

        if (loginService.checkLogin(request)) {
            String token = jwtUtilHelper.genarateToken(request.getUsername());



            User user = loginService.getUserByUsername(request.getUsername());
            responseData.setData(token);
            responseData.setRole(user.getRole());
        } else {
            responseData.setData("");
            responseData.setDescription("Invalid credentials!");
            responseData.setSuccess(false);
        }

        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    @GetMapping("/google")
    public ResponseEntity<Map<String, Object>> user(@AuthenticationPrincipal OAuth2User principal) {
        if (principal == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User not found");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("name", principal.getAttribute("name"));
        response.put("email", principal.getAttribute("email"));
        response.put("picture", principal.getAttribute("picture"));


        return ResponseEntity.ok(response);
    }
}

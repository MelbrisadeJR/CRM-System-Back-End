package com.melbrisade.project.controllers;

import com.melbrisade.project.entities.EmailVerifier;
import com.melbrisade.project.entities.Users;
import com.melbrisade.project.payload.JWTLoginSuccessResponse;
import com.melbrisade.project.payload.LoginRequest;
import com.melbrisade.project.security.JwtTokenProvider;
import com.melbrisade.project.services.MailService;
import com.melbrisade.project.services.MapValidationErrorService;
import com.melbrisade.project.services.UserService;
import com.melbrisade.project.validator.UserValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static com.melbrisade.project.security.SecurityConstant.TOKEN_PREFIX;
@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private MapValidationErrorService mapValidationErrorService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserValidation userValidator;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MailService emailService;

    @PostMapping("/login")
    private ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result) {
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if (errorMap != null) {
            return errorMap;
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(), loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = TOKEN_PREFIX + tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JWTLoginSuccessResponse(true, jwt));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody Users users, BindingResult result) {
        // Validate passwords match
        userValidator.validate(users, result);
        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);

        if (errorMap != null) {
            return errorMap;
        }
        Users newUsers = userService.savedUser(users);

        return new ResponseEntity<Users>(newUsers, HttpStatus.CREATED);
    }

    // verify user email REST api
    @GetMapping("/email_verification")
    public ResponseEntity<Object> verifyEmail(@RequestParam("token") String token) {
//        String token = request.getParameter("token");
        EmailVerifier emailVerifier = emailService.getEmailVerifierByToken(token);
        if (emailVerifier != null) {
            long userId = emailVerifier.getUserId();
            emailService.setUserEmailVerified(userId);
            return ResponseEntity.ok().body("Email Verification Succeed!");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

package com.budgetwise.service;

import com.budgetwise.repository.UserRepository;
import com.budgetwise.security.JwtTokenProvider;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AuthServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private OtpService otpService;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private AuthService authService;

    @Test
    void sendOtpShouldNotFailWhenEmailSendingFails() {
        when(userRepository.existsByEmail("test@example.com")).thenReturn(false);
        when(otpService.generateOtp("test@example.com")).thenReturn("123456");
        doThrow(new RuntimeException("Failed to send email"))
                .when(emailService)
                .sendVerificationOtpEmail("test@example.com", "123456");

        assertEquals("123456", authService.sendOtp("test@example.com"));
    }
}

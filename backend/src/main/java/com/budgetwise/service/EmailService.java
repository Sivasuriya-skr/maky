package com.budgetwise.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class EmailService {

    @Value("${brevo.api.key}")
    private String brevoApiKey;

    @Value("${app.name:BudgetWise}")
    private String appName;

    @Value("${app.support-email:support@budgetwise.com}")
    private String supportEmail;

    @Value("${app.base-url:http://localhost:3000}")
    private String baseUrl;

    private static final String BREVO_API_URL = "https://api.brevo.com/v3/smtp/email";

    public void sendVerificationOtpEmail(String toEmail, String otp) {
        String body = """
            {
                "sender": {"name": "%s", "email": "%s"},
                "to": [{"email": "%s"}],
                "subject": "%s - Email Verification Code",
                "htmlContent": "<h2>Your OTP is: <strong>%s</strong></h2><p>This code expires in 10 minutes.</p>"
            }
            """.formatted(appName, supportEmail, toEmail, appName, otp);

        sendEmail(body, toEmail);
    }

    public void sendPasswordResetEmail(String toEmail, String username, String resetToken) {
        String resetLink = baseUrl + "/reset-password?token=" + resetToken;
        String body = """
            {
                "sender": {"name": "%s", "email": "%s"},
                "to": [{"email": "%s"}],
                "subject": "%s - Password Reset Request",
                "htmlContent": "<h2>Hello %s,</h2><p>Click <a href='%s'>here</a> to reset your password. Link expires in 1 hour.</p>"
            }
            """.formatted(appName, supportEmail, toEmail, appName, username, resetLink);

        sendEmail(body, toEmail);
    }

    private void sendEmail(String jsonBody, String toEmail) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BREVO_API_URL))
                    .header("Content-Type", "application/json")
                    .header("api-key", brevoApiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 201) {
                log.info("Email sent successfully to: {}", toEmail);
            } else {
                log.error("Failed to send email. Status: {}, Body: {}", response.statusCode(), response.body());
                throw new RuntimeException("Failed to send email: " + response.body());
            }
        } catch (Exception e) {
            log.error("Error sending email to: {}", toEmail, e);
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
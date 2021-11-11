package com.prisma.libraryapplication;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.util.Assert;

import java.time.Duration;
import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class LibraryapplicationApplicationTests {
    
    @Autowired
    private WebTestClient webTestClient;
    
    private static final String USERS_PATH_URL = "/api/users";
    
    @Test
    void getUsers_usersAreReturned() {
        // Arrange
        
        // Act
        val users = client().get()
                .uri(uriBuilder -> uriBuilder.path(USERS_PATH_URL).build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class).returnResult().getResponseBody();
        
        // Assert
        Assert.notEmpty(users, () -> "Should return default users list");
    }
    
    protected WebTestClient client() {
        return webTestClient.mutate()
                .responseTimeout(Duration.ofMinutes(5))
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}

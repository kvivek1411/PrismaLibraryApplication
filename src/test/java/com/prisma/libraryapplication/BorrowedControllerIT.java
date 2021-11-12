package com.prisma.libraryapplication;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;


class BorrowedControllerIT extends BaseIntegrationTest{
    
    private static final String BORROWED_PATH_URL = "/api/borrowed";
    
    @Test
    void getUsers_usersAreReturned() {
        // Arrange
        
        // Act
        val results = client().get()
                .uri(uriBuilder -> uriBuilder.path(BORROWED_PATH_URL).build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class).returnResult().getResponseBody();
        
        // Assert
        Assert.notEmpty(results, () -> "Should return All list");
    }

    @Test
    void getActiveNonBorrowedUsers_usersAreReturned() {
        // Arrange

        // Act
        val results = client().get()
                .uri(uriBuilder -> uriBuilder.path(BORROWED_PATH_URL +"/users").build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class).returnResult().getResponseBody();

        // Assert
        Assert.notEmpty(results, () -> "Should return Non Borrowed list");
    }
    

}

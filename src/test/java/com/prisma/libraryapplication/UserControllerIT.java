package com.prisma.libraryapplication;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;


class UserControllerIT extends BaseIntegrationTest{
    
    private static final String USERS_PATH_URL = "/api/users";
    
    @Test
    void getUsers_usersAreReturned() {
        // Arrange
        
        // Act
        val results = client().get()
                .uri(uriBuilder -> uriBuilder.path(USERS_PATH_URL).build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class).returnResult().getResponseBody();
        
        // Assert
        Assert.notEmpty(results, () -> "Should return default results list");
    }

    @Test
    void getActiveNonBorrowedUsers_usersAreReturned() {
        // Arrange

        // Act
        val results = client().get()
                .uri(uriBuilder -> uriBuilder.path(USERS_PATH_URL+"/active/nonBorrowed").build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class).returnResult().getResponseBody();

        // Assert
        Assert.notEmpty(results, () -> "Should return Non Borrowed results list");
    }
    

}

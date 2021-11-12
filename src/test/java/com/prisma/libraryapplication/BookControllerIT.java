package com.prisma.libraryapplication;

import lombok.val;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.List;


class BookControllerIT extends BaseIntegrationTest{
    
    private static final String BOOKS_PATH_URL = "/api/books";
    
    @Test
    void getUsers_usersAreReturned() {
        // Arrange
        
        // Act
        val results = client().get()
                .uri(uriBuilder -> uriBuilder.path(BOOKS_PATH_URL).build())
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
                .uri(uriBuilder -> uriBuilder.path(BOOKS_PATH_URL +"/nonBorrowed").build())
                .exchange()
                .expectStatus().isOk()
                .expectBody(List.class).returnResult().getResponseBody();

        // Assert
        Assert.notEmpty(results, () -> "Should return Non Borrowed Books list");
    }
    

}

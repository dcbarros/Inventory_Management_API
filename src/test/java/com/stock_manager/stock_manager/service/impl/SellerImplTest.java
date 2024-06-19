package com.stock_manager.stock_manager.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.stock_manager.stock_manager.dto.request.SellerCreateDtoRequest;
import com.stock_manager.stock_manager.model.Seller;
import com.stock_manager.stock_manager.repository.SellerRepository;

public class SellerImplTest {

    @Mock
    private SellerRepository sellerRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private SellerImpl sellerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    
    @Test
    public void testCreateNewSeller_Success() {
        // Given
        
        SellerCreateDtoRequest request = new SellerCreateDtoRequest("Teste", "teste@testando.com", "password123");
        when(passwordEncoder.encode(request.password())).thenReturn("encodedPassword");

        // When
        sellerService.createNewSeller(request);

        // Then
        ArgumentCaptor<Seller> sellerCaptor = ArgumentCaptor.forClass(Seller.class);
        verify(sellerRepository).save(sellerCaptor.capture());

        Seller capturedSeller = sellerCaptor.getValue();
        assertNotNull(capturedSeller);
        assertEquals(request.name(), capturedSeller.getName());
        assertEquals(request.email(), capturedSeller.getEmail());
        assertEquals("encodedPassword", capturedSeller.getPassword());
    }

    @Test
    public void testCreateNewSeller_NullEmail() {
        // Given
        SellerCreateDtoRequest request = new SellerCreateDtoRequest("Teste", null, "password123");

        // When / Then
        assertThrows(IllegalArgumentException.class, () -> sellerService.createNewSeller(request));
        verifyNoInteractions(sellerRepository);
    }

    @Test
    public void testCreateNewSeller_NullName() {
        // Given
        SellerCreateDtoRequest request = new SellerCreateDtoRequest(null, "teste@testando.com", "password123");

        // When / Then
        assertThrows(IllegalArgumentException.class, () -> sellerService.createNewSeller(request));
        verifyNoInteractions(sellerRepository);
    }

    @Test
    public void testCreateNewSeller_NullPassword() {
        // Given
        SellerCreateDtoRequest request = new SellerCreateDtoRequest("Teste", "teste@testando.com", null);

        // When / Then
        assertThrows(IllegalArgumentException.class, () -> sellerService.createNewSeller(request));
        verifyNoInteractions(sellerRepository);
    }
}

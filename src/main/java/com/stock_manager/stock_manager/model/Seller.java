package com.stock_manager.stock_manager.model;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.stock_manager.stock_manager.model.enums.UserRoles;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seller implements UserDetails{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;
    @NotBlank(message = "O nome é um requisito")
    @Size(min = 3, message = "O nome deve ter pelo menos 3 caractéres")
    private String name;
    @NotBlank(message = "O email é um requisito")
    private String email;
    @NotBlank(message = "A senha é um requisito")
    @Size(min = 6, max = 8, message = "A senha deve ter entre 6 a 8 caracteres")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{6,8}$", message = "A senha deve possuir pelo menos uma letra maiúscula e um numeral")
    private String password;

    @OneToMany(mappedBy = "seller")
    private List<Sell> sells;

    @Enumerated(EnumType.STRING)
    private UserRoles role;

    private LocalDateTime updateAt;
    private LocalDateTime createAt;
    private LocalDateTime deleteAt;

    private Boolean isActive;
    private Boolean accountExpired;
    private Boolean credentialsExpired;
    private Boolean accountLocked;

    public Seller() {
    }

    public Seller(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;

        this.uuid = UUID.randomUUID();
        this.updateAt = LocalDateTime.now();
        this.createAt = LocalDateTime.now();
        this.deleteAt = LocalDateTime.now();

        this.role = UserRoles.USER;
        
        this.isActive = true;
        this.accountExpired = !isActive;
        this.accountLocked = !isActive;
        this.credentialsExpired = !isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.role.name()));
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !this.accountExpired;
    }
    
    @Override
    public boolean isAccountNonLocked() {
        return !this.accountLocked;
    }
    
    @Override
    public boolean isCredentialsNonExpired() {
        return !this.credentialsExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.isActive;
    }    
}

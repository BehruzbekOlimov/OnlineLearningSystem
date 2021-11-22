package uz.tuit.onlinelearningsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.tuit.onlinelearningsystem.entity.enums.Role;
import uz.tuit.onlinelearningsystem.entity.template.RootEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Table(name = "users")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User extends RootEntity implements UserDetails {

    @Column(nullable = false, length = 32)
    private String firstName;

    @Column(nullable = false, length = 32)
    private String lastName;

    private String address;

    @Column(unique = true, length = 16)
    private String phoneNumber;

    @Column(nullable = false, unique = true, length = 32)
    private String username;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    private Boolean enabled = true;

    @Enumerated(EnumType.STRING)
    @Column(length = 16)
    private Role role = Role.STUDENT;

    @Transient
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Subscriptions> subscriptions;

    @OneToOne(fetch = FetchType.LAZY)
    private Photo photo;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.name());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
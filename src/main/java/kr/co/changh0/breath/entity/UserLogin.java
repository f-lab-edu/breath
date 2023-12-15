package kr.co.changh0.breath.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@Entity
public class UserLogin {

    public UserLogin() {}

    @Id
    @Column(nullable = false, updatable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    private String password;

    @CreationTimestamp
    @Column(name = "create_dt")
    private LocalDateTime createDt;

    @UpdateTimestamp
    @Column(name = "update_dt")
    private LocalDateTime updateDt;

}

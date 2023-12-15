package kr.co.changh0.breath.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import kr.co.changh0.breath.common.boolType;
import kr.co.changh0.breath.common.genderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@Entity
public class User {

    public User() {}

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Integer userSeq;

    private String nickname;

    private String name;

    @Column(name = "birthday")
    private String birthDay;

    @Column(name = "mobile_phone")
    private String mobilePhone;

    private String gender;

    private String email;

    private String address;

    private String introduction;

    private String authority;

    @Column(name = "master_status")
    private String masterStatus;

    @Column(name = "create_dt")
    @CreationTimestamp
    private LocalDateTime createDt;

    @Column(name = "update_dt")
    @UpdateTimestamp
    private LocalDateTime updateDt;

    @Column(name = "delete_yn")
    private String deleteYn;

}

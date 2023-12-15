package kr.co.changh0.breath.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
@Getter
@AllArgsConstructor
@Builder
@Entity
public class Status {
    public Status() {}

    @Id
    private String statusId;

    private String status;

    private String useYn;

    @CreationTimestamp
    private LocalDateTime createDt;

    @LastModifiedDate
    private LocalDateTime updateDt;
}

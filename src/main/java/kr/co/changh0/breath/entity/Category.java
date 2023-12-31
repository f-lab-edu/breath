package kr.co.changh0.breath.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
public class Category {
    public Category() {}

    @Id
    private String categoryId;

    private String category;

    private String useYn;

    @CreationTimestamp
    private LocalDateTime createDt;

    @LastModifiedDate
    private LocalDateTime updateDt;
}

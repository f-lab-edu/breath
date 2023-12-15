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
@Builder
@AllArgsConstructor
@Entity
public class QnaType {
    public QnaType() {}

    @Id
    private String qnaTypeId;

    private String qnaType;

    private String useYn;

    @CreationTimestamp
    private LocalDateTime createDt;

    @LastModifiedDate
    private LocalDateTime updateDt;
}

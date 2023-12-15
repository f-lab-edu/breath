package kr.co.changh0.breath.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Blob;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@Entity
public class Post {
    public Post() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_seq", nullable = false, updatable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "parent_post_seq")
    private Post parentPost;

    @ManyToOne
    @JoinColumn(name = "user_seq")
    private User user;

    private Integer postNo;

    private String title;

    @Lob
    private Blob contents;

    private Integer targetAmount;

    private LocalDate donationStartDt;

    private LocalDate donationEndDt;

    private Integer reviewerSeq;

    private LocalDateTime reviewDt;

    @CreationTimestamp
    private LocalDateTime createDt;

    @UpdateTimestamp
    private LocalDateTime updateDt;

    private String mainYn;

    private String adultYn;

    private String secretYn;

    private String deleteYn;

    @ManyToOne
    @JoinColumn(name = "qna_type_id")
    private QnaType qnaType;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PostType type;

}

package com.rest.api.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "psj_review")
@Getter
@Setter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String rating;
    private String comment;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name = "regDate", nullable = false)
    private Date regDate;
}

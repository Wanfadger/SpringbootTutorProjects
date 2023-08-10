package com.wanfadger.QueryCriteria.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Id
    private String id;
    private boolean deleted = false;
    @CreationTimestamp
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    private LocalDateTime updatedDateTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false , name = "project_id" , referencedColumnName = "id")
    private Project project;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false , name = "taskStatus_id" , referencedColumnName = "id")
    private TaskStatus taskStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    private User user;

}

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
public class TaskStatus {
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Id
    private String id;
    private String name;
    private int priority;
    private boolean deleted = false;
    @CreationTimestamp
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    private LocalDateTime updatedDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false , name = "project_id" , referencedColumnName = "id")
    private Project project;

    @OneToOne(mappedBy = "taskStatus" , fetch = FetchType.LAZY)
    private Task task;

    public TaskStatus(String name, int priority, Project project) {
        this.name = name;
        this.priority = priority;
        this.project = project;
    }
}

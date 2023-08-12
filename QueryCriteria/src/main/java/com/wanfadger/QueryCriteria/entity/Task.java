package com.wanfadger.QueryCriteria.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty
    @NotBlank
    private String name;
    private String description;

    @Schema(hidden = true)
    private boolean deleted = false;
    @CreationTimestamp
    @Schema(
            description = "Date when record was created",
            pattern = "dd/mm/yyyy")
    private LocalDateTime createdDateTime;

    @UpdateTimestamp
    @Schema(
            description = "last updated date",
            pattern = "dd/mm/yyyy")
    private LocalDateTime updatedDateTime;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false , name = "project_id" , referencedColumnName = "id")
    @Schema(description = "task project")
    private Project project;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false , name = "taskStatus_id" , referencedColumnName = "id")
    @Schema(description = "task current status")
    private TaskStatus taskStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , referencedColumnName = "id")
    @Schema(description = "task assignee")
    private User user;

}

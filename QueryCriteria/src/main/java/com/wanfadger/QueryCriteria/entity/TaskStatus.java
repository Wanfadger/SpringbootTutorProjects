package com.wanfadger.QueryCriteria.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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

    @NotBlank
    @NotEmpty
    @Schema(description = "task status name")
    private String name;

    @NotBlank
    @NotEmpty
    @Schema(description = "task status priority")
    private int priority;
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
    @Schema(hidden = true)
    private Project project;

    @OneToOne(mappedBy = "taskStatus" , fetch = FetchType.LAZY)
    @Schema(hidden = true)
    private Task task;

    public TaskStatus(String name, int priority, Project project) {
        this.name = name;
        this.priority = priority;
        this.project = project;
    }
}

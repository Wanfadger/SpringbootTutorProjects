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
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {

    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Id
    private String id;
    @Column(nullable = false , unique = true)
    @NotBlank
    @NotEmpty
    @Schema(description = "project name")
    private String name;

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

    @OneToMany(mappedBy = "project")
    @Schema(description = "project tasks")
    private Set<Task> tasks;

    @OneToMany(mappedBy = "project" , cascade = CascadeType.ALL)
    @Schema(
            description = "project process flows")
    private Set<TaskStatus> taskStatuses;

    public Project(String name) {
        this.name = name;
    }
}

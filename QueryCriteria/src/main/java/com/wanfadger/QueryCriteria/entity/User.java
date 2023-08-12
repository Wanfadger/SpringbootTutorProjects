package com.wanfadger.QueryCriteria.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Id
    private String id;
    private String surname;
    private String givenName;
    private String email;

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

    @OneToMany(mappedBy = "user")
    @Schema(description = "users assigned tasks")
    private Set<Task> tasks= new HashSet<>();

}

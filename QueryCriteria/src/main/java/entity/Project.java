package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {

    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid")
    @Id
    private String id;
    private String name;
    private boolean deleted = false;

    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;

    @OneToMany(mappedBy = "project")
    private Set<Task> tasks;

    @OneToMany(mappedBy = "project")
    private Set<TaskStatus> taskStatuses;



}

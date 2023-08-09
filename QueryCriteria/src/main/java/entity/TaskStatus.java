package entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TaskStatus {
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid")
    @Id
    private String id;
    private String name;
    private int priority;
    private boolean deleted = false;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @OneToOne(mappedBy = "taskStatus" , fetch = FetchType.LAZY)
    private Task task;




}

package entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid")
    @Id
    private String id;
    private boolean deleted = false;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;


    @ManyToOne(fetch = FetchType.LAZY)
    private Project project;

    @OneToOne(fetch = FetchType.LAZY)
    private TaskStatus taskStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    private User assigned;

}

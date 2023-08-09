package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid")
    @Id
    private String id;
    private String surname;
    private String givenName;
    private String email;

    private boolean deleted = false;
    private LocalDateTime createdDateTime;
    private LocalDateTime updatedDateTime;

    @OneToMany(mappedBy = "assigned")
    private Set<Task> tasks= new HashSet<>();

}

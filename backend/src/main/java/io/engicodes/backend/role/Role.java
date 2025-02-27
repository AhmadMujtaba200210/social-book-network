package io.engicodes.backend.role;


import com.fasterxml.jackson.annotation.JsonIgnore;
import io.engicodes.backend.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Role {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(
            unique = true
    )
    private String name;
    @ManyToMany(
            mappedBy = "roles"
    )
    @JsonIgnore
    private List<User> users;
    @CreatedDate
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime createdDate;
    @LastModifiedBy
    @Column(
            insertable = false
    )
    private LocalDateTime lastModifiedDate;
}

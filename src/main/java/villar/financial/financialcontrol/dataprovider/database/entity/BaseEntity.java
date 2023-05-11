package villar.financial.financialcontrol.dataprovider.database.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID, generator = "uuid")
    private UUID uuid;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "modified_at")
    private LocalDateTime updatedAt;

    @Version
    private Integer version;

    @PrePersist
    public void prePersist() {
        setCreatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    public String getId() {
        return uuid.toString();
    }
}

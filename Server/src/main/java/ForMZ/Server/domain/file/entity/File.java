package ForMZ.Server.domain.file.entity;

import ForMZ.Server.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class File extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id")
    private Long id;
    @Column
    private String fileUrl;
    @Column
    private String fileOriginName;
    @Column
    private String key;
    @Column
    private String fileSize;
}

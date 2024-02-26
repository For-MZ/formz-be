package ForMZ.Server.global.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@MappedSuperclass // 아래 공통 필드를 컬럼으로 인식하게 함
public abstract class BaseEntity {

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private LocalDateTime deletedDate;

    //private objState
}

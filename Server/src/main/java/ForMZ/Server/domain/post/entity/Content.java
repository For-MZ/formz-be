package ForMZ.Server.domain.post.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class Content {
    @Column
    private String text;
    @Column
    private String imageUrl;
}

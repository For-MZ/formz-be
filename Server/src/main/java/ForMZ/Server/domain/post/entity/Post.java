package ForMZ.Server.domain.post.entity;

import ForMZ.Server.domain.category.entity.Category;
import ForMZ.Server.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String content;

    @Column
    private int view;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

    //@OneToMany(mappedBy = "post", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    //private List<Comment> comments = new ArrayList<>();

    //@OneToMany(mappedBy = "post", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    //private List<PostLike> postLikes = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    private Category category;
}

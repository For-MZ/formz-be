package ForMZ.Server.domain.comment.entity;

import ForMZ.Server.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private User user;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "POST_ID")
//    private Post post;

    //@OneToMany(mappedBy = "comment", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    //private List<Comment> commentChild = new ArrayList<>();

    //@OneToMany(mappedBy = "comment", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    //private List<CommentLike> commentLikes = new ArrayList<>();
}
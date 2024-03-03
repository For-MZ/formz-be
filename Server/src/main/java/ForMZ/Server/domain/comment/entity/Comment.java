package ForMZ.Server.domain.comment.entity;

import ForMZ.Server.domain.commentLike.entity.CommentLike;
import ForMZ.Server.domain.post.entity.Post;
import ForMZ.Server.domain.user.entity.User;
import ForMZ.Server.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long id;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POST_ID")
    private Post post;

    @OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Comment> commentChild = new ArrayList<>();

    @OneToMany(mappedBy = "comment", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<CommentLike> commentLikes = new ArrayList<>();
}
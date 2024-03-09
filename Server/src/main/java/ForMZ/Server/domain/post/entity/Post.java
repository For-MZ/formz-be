package ForMZ.Server.domain.post.entity;

import ForMZ.Server.domain.bookmark.entity.Bookmark;
import ForMZ.Server.domain.category.entity.Category;
import ForMZ.Server.domain.category.entity.CategoryCode;
import ForMZ.Server.domain.comment.entity.Comment;
import ForMZ.Server.domain.postLike.entity.PostLike;

import ForMZ.Server.domain.user.entity.User;
import ForMZ.Server.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private int view = 0;

    @Column
    private String text;

    @Column
    private String imageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<PostLike> postLikes = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Bookmark> bookmarks = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    /**
     *  조회수 증가
     */
    public void viewPlus(){
        this.view++;
    }
}

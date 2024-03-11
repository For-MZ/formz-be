package ForMZ.Server.domain.user.entity;

import ForMZ.Server.domain.bookmark.entity.Bookmark;
import ForMZ.Server.domain.comment.entity.Comment;
import ForMZ.Server.domain.commentLike.entity.CommentLike;
import ForMZ.Server.domain.file.entity.File;
import ForMZ.Server.domain.post.entity.Post;
import ForMZ.Server.domain.postLike.entity.PostLike;
import ForMZ.Server.global.entity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Email
    @Column(nullable = false)
    private String email;

    @Valid
    @Column(nullable = false)
    private String password;

    @Valid
    @Column(nullable = false)
    private String nickName;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private SignType signType;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Post> posts = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<Bookmark> bookmarks = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<CommentLike> commentLikes = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private List<PostLike> postLikes = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileImageId", referencedColumnName = "file_id")
    private File profileImage;

    public enum Role{
        USER,
        ADMIN
    }

    public enum SignType{
        NORMAL,
        GOOGLE,
        KAKAO
    }

    public void updateProfile(String email, String password, String nickName, String profileImage){
        if(email != null){
            this.email = email;
        }
        if(password != null){
            this.password = password;
        }
        if(nickName != null){
            this.nickName = nickName;
        }
        this.profileImage.updateFileUrl(profileImage);
    }
}
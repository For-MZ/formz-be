package ForMZ.Server.domain.post.repository;

import ForMZ.Server.domain.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}

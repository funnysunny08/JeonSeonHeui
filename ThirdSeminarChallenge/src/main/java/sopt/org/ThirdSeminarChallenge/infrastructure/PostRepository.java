package sopt.org.ThirdSeminarChallenge.infrastructure;

import org.springframework.data.repository.Repository;
import sopt.org.ThirdSeminarChallenge.domain.Post;

public interface PostRepository extends Repository<Post, Long> {
    void save(Post post);
    Post findPostById(Long postId);
}

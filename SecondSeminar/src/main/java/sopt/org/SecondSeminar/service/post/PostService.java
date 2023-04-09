package sopt.org.SecondSeminar.service.post;

import org.springframework.stereotype.Service;
import sopt.org.SecondSeminar.controller.post.dto.request.PostRequestDto;
import sopt.org.SecondSeminar.domain.post.Post;

import static sopt.org.SecondSeminar.SecondSeminarApplication.postList;

@Service
public class PostService {
    public Long post(PostRequestDto request) {
        Post newPost = new Post(
                request.getTitle(),
                request.getContent()
        );

        postList.add(newPost);
        newPost.setId((long) postList.size());

        return newPost.getId();
    }

    public String getOne(Long postId) {
        Post post = postList.get(postId.intValue() - 1);
        return post.getId() + "번 게시물" + post.getTitle() + "\n" + post.getContent();
    }

    public String search(String name) {
        String searchedPost = "";
        for (Post post: postList) {
            if (post.getTitle().contains(name) || post.getContent().contains(name)) {
                searchedPost += post.getId() + "\n" + post.getTitle() + "\n" + post.getContent() + "\n";
            }
        }
        return searchedPost;
    }
}

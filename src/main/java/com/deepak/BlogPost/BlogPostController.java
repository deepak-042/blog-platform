package com.deepak.BlogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog-post")
public class BlogPostController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping
    private List<BlogPost> getAllPosts(){
        return blogRepository.findAll();
    }

    @PostMapping
    public BlogPost createPost(
            @RequestBody BlogPost blogPost
    ){
        return blogRepository.save(blogPost);
    }

    @GetMapping("/{id}")
    public BlogPost getPostById(
            @PathVariable Long id
    ){
        return blogRepository.findById(id).
                orElseThrow(() -> new RuntimeException("not found "))  ;
    }

    @PutMapping("/{id}")
    public BlogPost updatePost(
            @PathVariable Long id,
            @RequestBody BlogPost updatedPost
    ){
        BlogPost existingPost = blogRepository.findById(id).
                orElseThrow(() -> new RuntimeException("not found"));
        existingPost.setTitle(updatedPost.getTitle());
        existingPost.setContent(updatedPost.getContent());
        return blogRepository.save(existingPost);
    }

    @DeleteMapping("/{id}")
    public void deletePost(
            @PathVariable Long id
    ){
      blogRepository.deleteById(id);
    }

}

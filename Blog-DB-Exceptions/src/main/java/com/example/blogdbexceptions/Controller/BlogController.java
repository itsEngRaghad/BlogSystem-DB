package com.example.blogdbexceptions.Controller;

import com.example.blogdbexceptions.Model.Blog;
import com.example.blogdbexceptions.Service.BlogService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {
    private final BlogService blogService;


    @GetMapping("/get")
    public ResponseEntity getAllBlogs(){
        List<Blog>blogs=blogService.getAllBlogs();
        return ResponseEntity.status(200).body(blogs);
    }

    @PostMapping("/add")
    public ResponseEntity addBlog(@Valid@RequestBody Blog blog){
        blogService.addBlog(blog);
        return ResponseEntity.status(200).body("Congrats! , Your Blog has been Successfully added!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@Valid@RequestBody Blog blog, @PathVariable Integer id){
        blogService.updateBlog(id,blog);
        return ResponseEntity.status(200).body("Congrats! , Your Blog has been Successfully updated!");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id){
        blogService.deleteBlog(id);
        return ResponseEntity.status(200).body("Sadly, Your Blog Has been Deleted ");
    }

    @GetMapping("/get-id/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
       Blog blog= blogService.findById(id);
        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/get-title/{title}")
    public ResponseEntity getByTitle(@PathVariable String title){
        Blog blog=blogService.findByTitle(title);
        return ResponseEntity.status(200).body(blog);
    }

    @GetMapping("/get-category/{category}")
    public ResponseEntity getByCategory(@PathVariable String category){
        List<Blog> blogs=blogService.getByCategory(category);
        return ResponseEntity.status(200).body(blogs);
    }

    @GetMapping("/change-publish/{id}")
    public ResponseEntity changePublished(@PathVariable Integer id){

        blogService.changePublished(id);
        return ResponseEntity.status(200).body("Your blog has been published succefully, Congrats!");
    }
}

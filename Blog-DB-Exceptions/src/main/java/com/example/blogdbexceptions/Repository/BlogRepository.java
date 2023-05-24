package com.example.blogdbexceptions.Repository;

import com.example.blogdbexceptions.Model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {

        Blog findBlogById(Integer id);

        Blog findBlogByTitle(String title);

        List<Blog> findBlogByCategory(String category);



}

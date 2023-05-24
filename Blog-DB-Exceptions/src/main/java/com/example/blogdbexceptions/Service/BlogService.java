package com.example.blogdbexceptions.Service;

import com.example.blogdbexceptions.APIException.APIException;
import com.example.blogdbexceptions.Model.Blog;
import com.example.blogdbexceptions.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
//    All CRUD\


    //get
    public List<Blog> getAllBlogs(){
        return blogRepository.findAll();
    }

    //add

    public void addBlog(Blog blog){
        blogRepository.save(blog);
    }

    //update

    public void updateBlog(Integer id, Blog blog){
        Blog oldBlog=blogRepository.findBlogById(id);
        if(oldBlog==null){
            throw new APIException("Blog not found, sorry :( ");
        }

        oldBlog.setTitle(blog.getTitle());
        oldBlog.setBody(blog.getBody());
        oldBlog.setCategory(blog.getCategory());
        oldBlog.setPublished(blog.isPublished());
        blogRepository.save(oldBlog);
    }


    //delete


    public void deleteBlog(Integer id){

        Blog theBlog=blogRepository.findBlogById(id);
        if(theBlog==null){
            throw new APIException("The Blog isn't Exist");
        }
        blogRepository.deleteById(id);
    }



//get Blog By id

    public Blog findById(Integer id){
        Blog idBlog=blogRepository.findBlogById(id);
        if(idBlog==null){
            throw new APIException("Sorry, We Couldn't find the Blog your looking for, Try another ID!");
        }
        return idBlog;
    }

    //get Blog By title
    public Blog findByTitle(String title){
        Blog titleBlog=blogRepository.findBlogByTitle(title);
        if(title==null){
            throw new APIException("sorry no such blog with this title :(, try another title");
        }
        return titleBlog;
    }

    //get Blog By Category

    public List<Blog> getByCategory(String category){
        List<Blog> categoryBlog= blogRepository.findBlogByCategory(category);
        if (category==null){

            throw new APIException("Sorry, no such category, try another category :( ");
        }
        return categoryBlog;
    }
        //change published states to True

    public void changePublished(Integer id){
        Blog oldBlog=blogRepository.findBlogById(id);
                if(oldBlog==null){
                    throw new APIException("sorry no blog to change status ");
                }
                 oldBlog.setPublished(true);
                blogRepository.save(oldBlog);

    }






}

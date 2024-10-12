package com.younus.Joblisting.Controller;

import com.younus.Joblisting.Repository.PostRepository;
import com.younus.Joblisting.Repository.SearchRepository;
import com.younus.Joblisting.model.Post;
import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // Allow cross-origin requests from localhost:3000 (React frontend).
public class PostController
{

    @Autowired
    PostRepository repo; // Inject PostRepository to handle basic CRUD operations for job posts.

    @Autowired
    SearchRepository srepo; // Inject SearchRepository to handle search functionality using MongoDB aggregation.

    @Hidden
    @RequestMapping(value="/") // Hidden API to redirect the base URL to the Swagger UI documentation.
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html"); // Redirect to Swagger UI for API documentation.
    }

    @GetMapping("/allPosts")
    @CrossOrigin
    public List<Post> getAllPosts() // Fetch all job posts from the MongoDB database.
    {
        return repo.findAll(); // Calls findAll() from MongoRepository to retrieve all records.
    }

    // Get posts that match the search text (e.g., job profile, description, or technologies).
    @GetMapping("/posts/{text}")
    @CrossOrigin
    public List<Post> search(@PathVariable String text) // Fetch job posts that match the provided search term.
    {
        return srepo.findByText(text); // Calls the custom search repository to search for posts.
    }

    @PostMapping("/post")
    @CrossOrigin
    public Post addPost(@RequestBody Post post) // Create and add a new job post to the database.
    {
        return repo.save(post); // Saves the job post to MongoDB using MongoRepository's save() method.
    }
}

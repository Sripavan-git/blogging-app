package com.pavan.blogapp.controllers;

import com.pavan.blogapp.payloads.ApiResponse;
import com.pavan.blogapp.payloads.PostDTO;
import com.pavan.blogapp.repositories.PostRepository;
import com.pavan.blogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class PostController {

    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    // Create Post API
    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable Long userId, @PathVariable Long categoryId){
        PostDTO createdPost = postService.createPost(postDTO, userId, categoryId);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }


    // Get All Posts By User API
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByUser(@PathVariable Long userId){
        List<PostDTO> postDTOS = this.postService.getPostsByUser(userId);
        return new ResponseEntity<>(postDTOS, HttpStatus.OK);
    }

    // Get All Posts by Category API
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getPostsByCategory(@PathVariable Long categoryId){
        List<PostDTO> postDTOS = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<>(postDTOS, HttpStatus.OK);
    }

    // Get All Posts
    @GetMapping("/posts")
    public ResponseEntity<List<PostDTO>> getAllPosts(){
        return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
    }

    // Get Post by Id
    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> getPostById(@PathVariable Long postId){
        return new ResponseEntity<>(postService.getPostById(postId), HttpStatus.OK);
    }

    // Update Post
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable Long postId){
        return new ResponseEntity<>(postService.updatePost(postDTO, postId), HttpStatus.OK);
    }

    // Delete Post by Id
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Long postId){
        this.postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post with "+ postId + " deleted Sucessfully ", true), HttpStatus.OK);
    }

}

package com.pavan.blogapp.services;

import com.pavan.blogapp.modals.Category;
import com.pavan.blogapp.modals.Post;
import com.pavan.blogapp.modals.User;
import com.pavan.blogapp.payloads.PostDTO;

import java.util.List;

public interface PostService {

    //Create Post
    PostDTO createPost(PostDTO postDTO, Long userId, Long categoryId);

    //Update Post
    PostDTO updatePost(PostDTO postDTO);

    //Delete Post
    void deletePost(Long postId);

    //Get All Posts
    List<PostDTO> getAllPosts();

    //Get Post by id
    PostDTO getPostById(Long postId);

    //Get Post By Category
    List<PostDTO> getPostsByCategory(Long categoryId);

    //Get Post by User
    List<PostDTO> getPostsByUser(Long userId);

    List<PostDTO> searchPosts(String keyword);
}

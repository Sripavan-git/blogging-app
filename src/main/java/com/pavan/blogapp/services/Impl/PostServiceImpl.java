package com.pavan.blogapp.services.Impl;

import com.pavan.blogapp.exceptions.ResourceNotFoundException;
import com.pavan.blogapp.modals.Category;
import com.pavan.blogapp.modals.Post;
import com.pavan.blogapp.modals.User;
import com.pavan.blogapp.payloads.PostDTO;
import com.pavan.blogapp.repositories.CategoryRepository;
import com.pavan.blogapp.repositories.PostRepository;
import com.pavan.blogapp.repositories.UserRepository;
import com.pavan.blogapp.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PostDTO createPost(PostDTO postDTO, Long userId, Long categoryId) {

        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "user Id", userId));
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        Post post = modelMapper.map(postDTO, Post.class);
        post.setImageName("default.png");
        post.setAddedDate(new Date());
        post.setUser(user);
        post.setCategory(category);

        Post savedPost = this.postRepository.save(post);
        return this.modelMapper.map(savedPost,PostDTO.class);
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO) {
        return null;
    }

    @Override
    public void deletePost(Long postId) {
        Post post = this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
        postRepository.delete(post);
    }

    @Override
    public List<PostDTO> getAllPosts() {
        return this.postRepository.findAll().stream().map(Post -> this.modelMapper.map(Post, PostDTO.class)).toList();
    }

    @Override
    public PostDTO getPostById(Long postId) {
        Post post =  this.postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));
        return modelMapper.map(post, PostDTO.class);
    }

    @Override
    public List<PostDTO> getPostsByCategory(Long categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        List<Post> posts = this.postRepository.findByCategory(category);
        return posts.stream().map((post) -> this.modelMapper.map(post, PostDTO.class)).toList();
    }

    @Override
    public List<PostDTO> getPostsByUser(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", "UserId", userId));
        List<Post> posts = this.postRepository.findByUser(user);
        return posts.stream().map((post) -> this.modelMapper.map(post, PostDTO.class)).toList();
    }

    @Override
    public List<PostDTO> searchPosts(String keyword){
        return List.of();
    }
}

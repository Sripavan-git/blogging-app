package com.pavan.blogapp.repositories;

import com.pavan.blogapp.modals.Category;
import com.pavan.blogapp.modals.Post;
import com.pavan.blogapp.modals.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByUser(User user);
    List<Category> findByCategory(Category category);
}

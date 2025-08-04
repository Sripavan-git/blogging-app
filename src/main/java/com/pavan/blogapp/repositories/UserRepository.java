package com.pavan.blogapp.repositories;

import com.pavan.blogapp.modals.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}

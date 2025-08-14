package com.pavan.blogapp.payloads;

import com.pavan.blogapp.modals.Category;
import com.pavan.blogapp.modals.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private UserDTO user;
    private CategoryDTO category;
}

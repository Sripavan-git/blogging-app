package com.pavan.blogapp.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class CategoryDTO {

    private long categoryId;
    private String categoryTitle;
    private String categoryDescription;
}

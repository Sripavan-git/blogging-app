package com.pavan.blogapp.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
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
    @NotEmpty
    @Size(min = 4, message = "Minimum Size fo the Title should be 4")
    private String categoryTitle;

    @NotEmpty
    @Size(min = 10, message = "Minimum size of the Description should be 10 ")
    private String categoryDescription;
}

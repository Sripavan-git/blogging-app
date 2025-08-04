package com.pavan.blogapp.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {

    public String resourceName;
    public String fieldName;
    public Long fieldValue;

    public ResourceNotFoundException( String resourceName, String fieldName, Long fieldValue) {
        super(String.format("Resource %s not found with name %s and value %d", resourceName, fieldName, fieldValue));
        this.resourceName = resourceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}

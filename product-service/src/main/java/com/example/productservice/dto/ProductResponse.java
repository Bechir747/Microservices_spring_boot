package com.example.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//DTOs facilitate efficient and controlled data exchange between different layers or components of an application, enhancing separation of concerns and reducing over-fetching of data.
@Data // generate all getters and setters
@Builder
@AllArgsConstructor
@NoArgsConstructor
// generate contructor with args and without
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}

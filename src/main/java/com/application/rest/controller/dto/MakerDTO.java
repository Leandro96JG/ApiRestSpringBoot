package com.application.rest.controller.dto;

import com.application.rest.entities.Product;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode

public class MakerDTO {
    private Long id;

    @NotBlank(message = "Name is Blank")
    private String name;

    private List<Product> productList = new ArrayList<>();
}

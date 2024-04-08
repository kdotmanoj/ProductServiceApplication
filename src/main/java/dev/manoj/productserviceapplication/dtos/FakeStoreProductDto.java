package dev.manoj.productserviceapplication.dtos;

import lombok.Getter;
import lombok.Setter;

//Dto class gives control to the company to share only the data which they wish to expose to the client
@Getter
@Setter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}

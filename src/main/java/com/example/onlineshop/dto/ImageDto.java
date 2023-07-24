package com.example.onlineshop.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ImageDto {
    //    String imageName;
//    String imageExtension;
//    String imageData;
    @JsonProperty("imageName")
    String imageName;

    @JsonProperty("imageData")
    String imageData;

    @JsonProperty("imageExtension")
    String imageExtension;

//    Long ProductId;
}

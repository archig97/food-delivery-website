package com.java.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data
@Embeddable  /*An embeddable class does not have its own table.
Instead, its fields are merged into the table of the entity that embeds it.
The embedded class does not have its own primary key.*/
public class RestaurantDto {

    private Long id;
    private String title;

    @Column(length = 1000)
    private List<String> images;

    //according to GPT, according 2 lines are problematic and may cause errors
    //Below is recommended fix.

    /*@Column(length = 1000)
    private String images; // Stores a comma-separated list of URLs

    public List<String> getImages() {
        return images == null ? new ArrayList<>() : Arrays.asList(images.split(","));
    }

    public void setImages(List<String> images) {
        this.images = String.join(",", images);
    }*/

    private String description;


}

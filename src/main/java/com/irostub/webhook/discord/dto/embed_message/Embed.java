package com.irostub.webhook.discord.dto.embed_message;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Embed {
    private String title;
    private String description;
    private String url;
    private Integer color;
    private String timestamp;
    private List<Field> fields = new ArrayList<>();
    private Author author;
    private Footer footer;
    private Image image;
    private Thumbnail thumbnail;
}

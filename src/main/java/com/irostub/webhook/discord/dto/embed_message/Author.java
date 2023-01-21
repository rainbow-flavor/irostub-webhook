package com.irostub.webhook.discord.dto.embed_message;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Author {
    private String name;
    private String url;
    private String icon_url;
}

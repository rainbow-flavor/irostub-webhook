package com.irostub.webhook.discord.dto.embed_message;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Image {
    private String url;
}

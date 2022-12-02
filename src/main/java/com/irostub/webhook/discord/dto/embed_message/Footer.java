package com.irostub.webhook.discord.dto.embed_message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.lang.Nullable;

@Data
public class Footer {
    private String text;
    @JsonProperty("icon_url")
    private String iconUrl;

    public static Footer create(@Nullable String text, @Nullable String iconUrl){
        Footer footer = new Footer();
        footer.text = text;
        footer.iconUrl = iconUrl;
        return footer;
    }
}

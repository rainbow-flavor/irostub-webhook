package com.irostub.webhook.discord.dto.embed_message;

import lombok.Data;
import org.springframework.util.StringUtils;

@Data
public class Field {
    private String name;
    private String value;

    public void setValue(String value) {
        if (StringUtils.hasText(value) == false) {
            this.value = "기준 임계치가 없습니다.";
        }else{
            this.value = value;
        }
    }
}

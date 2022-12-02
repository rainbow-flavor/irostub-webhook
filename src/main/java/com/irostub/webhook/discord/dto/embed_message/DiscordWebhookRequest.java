package com.irostub.webhook.discord.dto.embed_message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * <pre>
 * {
 *   "content": "sample content",
 *   "embeds": [
 *     {
 *       "title": "What's this about?",
 *       "description": "embed message description",
 *       "url": "http://localhost:8080",
 *       "color": 5814783,
 *       "fields": [
 *         {
 *           "name": "my field1",
 *           "value": "myField Desc"
 *         }
 *       ],
 *       "author": {
 *         "name": "author",
 *         "url": "http://localhost:8080",
 *         "icon_url": "http://cdn.eso.org/images/screen/eso1907a.jpg"
 *       },
 *       "footer": {
 *         "text": "my footer",
 *         "icon_url": "http://cdn.eso.org/images/screen/eso1907a.jpg"
 *       },
 *       "timestamp": "2022-11-30T15:00:00.000Z",
 *       "image": {
 *         "url": "http://cdn.eso.org/images/screen/eso1907a.jpg"
 *       },
 *       "thumbnail": {
 *         "url": "http://cdn.eso.org/images/screen/eso1907a.jpg"
 *       }
 *     }
 *   ],
 *   "username": "this bot username",
 *   "avatar_url": "http://cdn.eso.org/images/screen/eso1907a.jpg"
 * }
 * </pre>
 */
@Builder
@Data
public class DiscordWebhookRequest {
    private String content;
    private List<Embed> embeds = new ArrayList<>();
    private String username;
    @JsonProperty(value = "avatar_url")
    private String avatarUrl;
}

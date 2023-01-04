package com.irostub.webhook.nas.mediator;

import com.irostub.webhook.config.AppConfig;
import com.irostub.webhook.discord.dto.embed_message.DiscordWebhookRequest;
import com.irostub.webhook.discord.dto.embed_message.Embed;
import com.irostub.webhook.discord.dto.embed_message.Field;
import com.irostub.webhook.discord.dto.embed_message.Footer;
import com.irostub.webhook.nas.dto.NasWebhookReceiveDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/nas")
public class NasHookReceiveController {
    private final RestTemplate restTemplate;
    private final AppConfig appConfig;
    private static final int YELLOW = 16767295;

    @PostMapping("/discord/mediator")
    public String nasToDiscordHook(@RequestBody NasWebhookReceiveDto dto) {
        log.debug("nas message = {}", dto);
        NasWebhookReceiveDto.ParsedMessage parsedMessage = dto.getParsedMessage();

        Field time = new Field();
        time.setName("발생 시간");
        time.setValue(parsedMessage.getTime());

        Field hostName = new Field();
        hostName.setName("발생 호스트");
        hostName.setValue(parsedMessage.getHostName());

        Embed embed = Embed.builder()
                .title(parsedMessage.getTitle())
                .description(parsedMessage.getContent())
                .fields(List.of(time, hostName))
                .color(YELLOW)
                .footer(Footer.create("host: ironas 에서 관측됨.", "https://i.imgur.com/eYpqeWR.png"))
                .build();
        DiscordWebhookRequest request = DiscordWebhookRequest.builder()
                .username("NAS 상태 알림 봇")
                .embeds(List.of(embed))
                .build();

        return restTemplate.postForObject(appConfig.getDiscord().getUrl(), request, String.class);
    }
}

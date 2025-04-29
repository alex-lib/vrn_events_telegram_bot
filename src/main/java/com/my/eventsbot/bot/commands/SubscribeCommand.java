package com.my.eventsbot.bot.commands;
import com.my.eventsbot.services.SubscriberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@AllArgsConstructor
@Service
@Slf4j
public class SubscribeCommand implements IBotCommand {
    private final SubscriberService service;

    @Override
    public String getCommandIdentifier() {
        return "subscribe";
    }

    @Override
    public String getDescription() {
        return "Subscribes user to receive notifications about upcoming events.";
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        User user = message.getFrom();
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());

        boolean hasSubscription = service.subscribeUser(user);
        System.out.println(hasSubscription);

        if (hasSubscription) {
            try {
                answer.setText("Вы подписаны ✅");
                absSender.execute(answer);
            } catch (TelegramApiException e) {
                log.error("Error occurred in /subscribe command", e);
            }
        }
    }
}

package com.my.eventsbot.bot.commands;
import com.my.eventsbot.services.SubscriberService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@AllArgsConstructor
@Slf4j
public class StartCommand implements IBotCommand {
    private final SubscriberService service;

    @Override
    public String getCommandIdentifier() {
        return "start";
    }

    @Override
    public String getDescription() {
        return "Launch bot and save user's data to database";
    }

    @Override
    public void processMessage(AbsSender absSender, Message message, String[] strings) {
        User user = message.getFrom();
        service.findOrSaveSubscriber(user);
        SendMessage answer = new SendMessage();
        answer.setChatId(message.getChatId());
        answer.setText("""
               Привет!\s
               Я бот, который поможет тебе быть в курсе ближайших эвентов в Воронеже
               Доступные команды:
               /subscribe - получать уведомления о новых запланированых эвентах
               /unsubscribe - отписаться от получения уведомлений
               /get_last_updates - получить информацию о последних 5 запланированных эвентах
               /support - поддержать дальнейшее развитие проекта
               \s""");
        try {
            absSender.execute(answer);
        } catch (TelegramApiException e) {
            log.error("Error occurred in /start command", e);
        }
    }
}

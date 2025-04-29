//package com.my.eventsbot.bot.commands;
//import com.my.eventsbot.services.EventService;
//import com.my.eventsbot.services.SubscriberService;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//import org.telegram.telegrambots.extensions.bots.commandbot.commands.IBotCommand;
//import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
//import org.telegram.telegrambots.meta.api.objects.Message;
//import org.telegram.telegrambots.meta.api.objects.User;
//import org.telegram.telegrambots.meta.bots.AbsSender;
//
//@Service
//@AllArgsConstructor
//@Slf4j
//public class GetLastUpdatesCommand implements IBotCommand {
//    private final SubscriberService service;
//    private final EventService eventService;
//
//    @Override
//    public String getCommandIdentifier() {
//        return "get_last_updates";
//    }
//
//    @Override
//    public String getDescription() {
//        return "Return last 5 events";
//    }
//
//    @Override
//    public void processMessage(AbsSender absSender, Message message, String[] strings) {
//        User user = message.getFrom();
//        SendMessage answer = new SendMessage();
//        answer.setChatId(message.getChatId());
//    }
//}

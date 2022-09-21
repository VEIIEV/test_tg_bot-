package com.example.tgbot;

import com.example.tgbot.Entity.ActiveChat;
import com.example.tgbot.repository.ActiveChatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class ActiveChatRepositoryTest {

    @Autowired
    private ActiveChatRepository activeChatRepository;

    @Test
    public void testRepo_found() {
        // создаём экземпляр
        final ActiveChat activeChat = new ActiveChat();
        // заполняем атрибут каким-нибудь значением
        activeChat.setChatId(12345L);
        // сохраняем объект в базу
        activeChatRepository.save(activeChat);
        // ищем объект кастомным методом по chatId
        Optional<ActiveChat> activeChatByChatId = activeChatRepository.findActiveChatByChatId(12345L);
        // проверяем, что объект найден
        assertTrue(activeChatByChatId.isPresent());
        // и что он имеет нужное значение
        assertEquals(12345L, activeChatByChatId.get().getChatId());
    }

    @Test
    public void testRepo_notFound() {
        final ActiveChat activeChat = new ActiveChat();
        activeChat.setChatId(12345L);
        activeChatRepository.save(activeChat);
        Optional<ActiveChat> activeChatByChatId = activeChatRepository.findActiveChatByChatId(54321L);
        // мы искали несуществующий объект, поэтому проверяем, что он не нашёлся
        assertFalse(activeChatByChatId.isPresent());
    }
}
package pro.sky.telegrambot.listener;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class TelegramBotUpdatesListener implements UpdatesListener {
    private static String STR_CMD = "/start";
    private static String GREET_MSG = "Welcome to chatbot!";
    private Logger logger = LoggerFactory.getLogger(TelegramBotUpdatesListener.class);

    @Autowired
    private TelegramBot telegramBot;

    @PostConstruct
    public void init() {
        telegramBot.setUpdatesListener(this);
    }

    @Override
    public int process(List<Update> updates) {
        updates.forEach(update -> {
            logger.info("Processing update: {}", update);
            Message message = update.message();

            if (message.text().equals(STR_CMD)) {
                logger.info("Command's been recieved: " + STR_CMD);
                sendMessage(showChatId(message), GREET_MSG);
            }
            ;
        });
        return UpdatesListener.CONFIRMED_UPDATES_ALL;
    }

    private void sendMessage(Long chatId, String messageContent) {
        SendMessage sendMessage = new SendMessage(chatId, messageContent);
        telegramBot.execute(sendMessage);
    }


    private void sendMessage(NotificationTask task) {
        sendMessage(task.getChatId(), task.getMessageContent());
    }

    private Long showChatId(Message message) {
        return message.chat().id();
    }
}

package pro.sky.telegrambot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import java.util.logging.Logger;

@AllArgsConstructor
@NoArgsConstructor
public class Bot extends TelegramLongPollingBot {

    private static final Logger log = Logger.getLogger(Bot.class);

    final int RECONNECT_PAUSE =10000;

    @Setter
    @Getter
    String userName;
    @Setter
    @Getter
    String token;

    @Override
    public void onUpdateReceived(Update update) {
        long chat_id = update.getMessage().getChatId();
        log.debug("new Update recieve");
    }

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    public void botConnect() {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(this);
            log.info("TelegramAPI started. Look for messages");
        } catch (TelegramApiRequestException e) {
            log.error("Cant Connect. Pause " + RECONNECT_PAUSE / 1000 + "sec and try again. Error: " + e.getMessage());
            try {
                Thread.sleep(RECONNECT_PAUSE);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
                return;
            }
            botConnect();
        }
    }
}

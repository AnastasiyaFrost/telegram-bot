package pro.sky.telegrambot.enity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
public class NotificationTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    private int chatId;
    private String notificationText;
    private LocalDateTime notificationSendDatetime;

    public NotificationTask(long id, int chatId, String notificationText,
                            LocalDateTime notificationSendDatetime) {
        this.id = id;
        this.chatId = chatId;
        this.notificationText = notificationText;
        this.notificationSendDatetime = notificationSendDatetime;
    }

    public NotificationTask() {

    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public String getNotificationText() {
        return notificationText;
    }

    public void setNotificationText(String notificationText) {
        this.notificationText = notificationText;
    }

    public LocalDateTime getNotificationSendDatetime() {
        return notificationSendDatetime;
    }

    public void setNotificationSendDatetime(LocalDateTime notificationSendDatetime) {
        this.notificationSendDatetime = notificationSendDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NotificationTask that = (NotificationTask) o;
        return id == that.id && chatId == that.chatId && Objects.equals(notificationText, that.notificationText) && Objects.equals(notificationSendDatetime, that.notificationSendDatetime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, chatId, notificationText, notificationSendDatetime);
    }

    @Override
    public String toString() {
        return "TelegramBotNotificationTask{" +
                "id=" + id +
                ", chatId=" + chatId +
                ", notificationText='" + notificationText + '\'' +
                ", notificationSendDatetime=" + notificationSendDatetime +
                '}';
    }
}

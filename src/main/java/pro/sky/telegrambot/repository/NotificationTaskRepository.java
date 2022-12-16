package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.telegrambot.enity.TelegramBotNotificationTask;

import javax.persistence.Id;

public interface NotificationTaskRepository extends JpaRepository<TelegramBotNotificationTask, Id> {
}

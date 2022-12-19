package pro.sky.telegrambot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pro.sky.telegrambot.entity.NotificationTask;

import javax.persistence.Id;
import java.util.List;

@Repository
public interface NotificationTaskRepository extends JpaRepository<NotificationTask, Id> {
    @Query(value = "SELECT * FROM DB_teleBot WHERE notificationSendDatetime = " +
            "LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES)", nativeQuery = true)
    List<NotificationTask> getTasksToSend();
}

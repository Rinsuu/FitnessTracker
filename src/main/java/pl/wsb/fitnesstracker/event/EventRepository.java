package pl.wsb.fitnesstracker.event;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT e FROM Event e WHERE e.startDate > :now ORDER BY e.startDate")
    List<Event> findUpcoming(@Param("now") LocalDate now);

    @Query(value = "SELECT e.name AS name, COUNT(ue.id) AS enrolledCount " +
            "FROM events e " +
            "LEFT JOIN user_events ue ON e.id = ue.event_id " +
            "GROUP BY e.id, e.name", nativeQuery = true)
    List<Object[]> findEventNamesWithEnrolledCount();
}

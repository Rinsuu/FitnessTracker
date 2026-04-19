package pl.wsb.fitnesstracker.workoutsession;

import pl.wsb.fitnesstracker.training.api.Training;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;

@Entity
@Table(name = "workout_sessions")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class WorkoutSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Nullable
    private Long id;

    @ManyToOne
    @JoinColumn(name = "training_id", nullable = false)
    private Training training;

    @Column(nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "start_latitude", nullable = false)
    private double startLatitude;

    @Column(name = "start_longitude", nullable = false)
    private double startLongitude;

    @Column(name = "end_latitude")
    private double endLatitude;

    @Column(name = "end_longitude")
    private double endLongitude;

    @Column(nullable = false)
    private double altitude;
}

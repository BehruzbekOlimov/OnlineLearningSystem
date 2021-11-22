package uz.tuit.onlinelearningsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.tuit.onlinelearningsystem.entity.enums.QuizStatus;
import uz.tuit.onlinelearningsystem.entity.template.RootEntity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "quiz")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Quiz extends RootEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;

    private Float score;

    @Enumerated(EnumType.STRING)
    private QuizStatus status;
}
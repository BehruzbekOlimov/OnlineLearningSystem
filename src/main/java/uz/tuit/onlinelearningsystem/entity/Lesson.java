package uz.tuit.onlinelearningsystem.entity;

import lombok.*;
import uz.tuit.onlinelearningsystem.entity.enums.TypeRate;
import uz.tuit.onlinelearningsystem.entity.template.RootEntity;

import javax.persistence.*;

@Table(name = "lessons")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Lesson extends RootEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Section section;

    @Column(length = 128)
    private String name;

    @Column(length = 10240)
    private String content;
//    private Long quizMaxTime;
    @Column(length = 16)
    @Enumerated(EnumType.STRING)
    private TypeRate typeRate;
    private Integer orderNumber;
    private Integer countTest;
    private Integer maxAttempts=Integer.MAX_VALUE;
    private Integer totalAttempts=0;

    @Transient
    private Quiz quiz;
}
package uz.tuit.onlinelearningsystem.entity;

import lombok.*;
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
    private Course course;

    @Column(length = 64)
    private String name;

    private String text;
    private Integer orderNumber;
}
package uz.tuit.onlinelearningsystem.entity;

import lombok.*;
import uz.tuit.onlinelearningsystem.entity.template.RootEntity;

import javax.persistence.*;

@Table(name = "subscriptions")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Subscriptions extends RootEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @ManyToOne(fetch = FetchType.LAZY)
    private User student;

    private byte rate;
}
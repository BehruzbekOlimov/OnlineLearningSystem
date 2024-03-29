package uz.tuit.onlinelearningsystem.entity;

import lombok.*;
import uz.tuit.onlinelearningsystem.entity.enums.CourseStatus;
import uz.tuit.onlinelearningsystem.entity.template.RootEntity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "courses")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Course extends RootEntity {
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = User.class)
    @JoinColumn(nullable = false)
    private User teacher;

    @Column(length = 128, nullable = false)
    private String name;

    @Column(length = 128, nullable = false)
    private String slugName;

    @Transient
    @OneToMany(fetch = FetchType.LAZY)
    private Set<Subscriptions> subscriptions;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
    private Set<Section> sections;

    @Column(length = 16)
    @Enumerated(EnumType.STRING)
    private CourseStatus status = CourseStatus.BEING_CREATE;

    @OneToOne(fetch = FetchType.LAZY)
    private Photo photo;
}
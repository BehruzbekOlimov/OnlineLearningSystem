package uz.tuit.onlinelearningsystem.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.tuit.onlinelearningsystem.entity.template.RootEntity;

import javax.persistence.*;
import java.util.Set;

@Table(name = "section")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Section extends RootEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    @Column(length = 128)
    private String name;
    private Integer orderNumber;

    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.REMOVE)
    @JsonBackReference
    private Set<Lesson> lessons;
}
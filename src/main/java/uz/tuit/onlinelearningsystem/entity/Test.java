package uz.tuit.onlinelearningsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.tuit.onlinelearningsystem.entity.template.RootEntity;

import javax.persistence.*;
import java.util.List;

@Table(name = "test")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Test extends RootEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    private Lesson lesson;
    @Column(length = 1024)
    private String question;
    private String answer;
    private String variant_b;
    private String variant_c;
    private String variant_d;
}
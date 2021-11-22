package uz.tuit.onlinelearningsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.tuit.onlinelearningsystem.entity.template.RootEntity;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;

@Table(name = "attachment")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Attachment extends RootEntity {

    @Lob
    private byte [] data;
}
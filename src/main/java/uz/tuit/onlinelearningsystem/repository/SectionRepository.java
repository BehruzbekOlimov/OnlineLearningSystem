package uz.tuit.onlinelearningsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tuit.onlinelearningsystem.entity.Section;

import java.util.UUID;
@Repository

public interface SectionRepository extends JpaRepository<Section, UUID> {
}
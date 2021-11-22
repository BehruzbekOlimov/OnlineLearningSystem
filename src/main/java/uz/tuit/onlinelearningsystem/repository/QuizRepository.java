package uz.tuit.onlinelearningsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.tuit.onlinelearningsystem.entity.Quiz;

import java.util.UUID;
@Repository

public interface QuizRepository extends JpaRepository<Quiz, UUID> {
}
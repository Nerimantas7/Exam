package lt.techin.exam.repository;

import lt.techin.exam.entity.AdvertComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertCommentRepository extends JpaRepository<AdvertComment, Long> {
}

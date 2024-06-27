package lt.techin.exam.repository;

import lt.techin.exam.entity.Advert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvertRepository extends JpaRepository <Advert, Long>{
}

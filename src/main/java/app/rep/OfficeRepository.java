package app.rep;

import app.obj.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OfficeRepository extends JpaRepository<Office, Long> {
    @Query(value = "SELECT o FROM Office o WHERE o.index = ?1")
    List<Office> findOfficesByIndex(String index);
}

package app.rep;

import app.obj.PackageType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageTypeRepository extends JpaRepository<PackageType, Long> {
}

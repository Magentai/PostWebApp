package app.rep;

import app.obj.PostPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<PostPackage, Long> {
}

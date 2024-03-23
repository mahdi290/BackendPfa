package tech.getarrays.employeemanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.employeemanager.model.ServiceModel;

import java.util.Optional;

public interface ServiceRepo extends JpaRepository<ServiceModel, Long> {
    void deleteServiceById(Long id);

    Optional<ServiceModel> findServiceById(Long id);
}

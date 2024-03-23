package tech.getarrays.employeemanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.employeemanager.exception.ServiceNotFoundException;
import tech.getarrays.employeemanager.model.ServiceModel;
import tech.getarrays.employeemanager.repo.ServiceRepo;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ServiceService {
    private final ServiceRepo serviceRepo;


    @Autowired
    public ServiceService(ServiceRepo serviceRepo) {
        this.serviceRepo = serviceRepo;
    }

    public ServiceModel addService(ServiceModel service) {
        // Enregistrer le service dans la base de données et le retourner
        return serviceRepo.save(service);
    }

    public List<ServiceModel> findAllServices() {
        // Récupérer tous les services depuis la base de données
        return serviceRepo.findAll();
    }

    public ServiceModel updateService(ServiceModel service) {
        // Mettre à jour le service dans la base de données et le retourner
        return serviceRepo.save(service);
    }

    public ServiceModel findServiceById(Long id) {
        // Rechercher un service par son identifiant dans la base de données
        return serviceRepo.findById(id)
                .orElseThrow(() -> new ServiceNotFoundException("Service with id " + id + " was not found"));
    }

    public void deleteService(Long id) {
        // Supprimer un service par son identifiant de la base de données
        serviceRepo.deleteById(id);
    }
}
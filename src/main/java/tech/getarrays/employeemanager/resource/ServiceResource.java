package tech.getarrays.employeemanager.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.employeemanager.model.ServiceModel;
import tech.getarrays.employeemanager.service.ServiceService;

import java.util.List;

@RestController
@RequestMapping("/service")
public class ServiceResource {
    private final ServiceService serviceService;



    public ServiceResource(ServiceService serviceService) {
        this.serviceService = serviceService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ServiceModel>> getAllServices() {
        List<ServiceModel> services = serviceService.findAllServices();
        return new ResponseEntity<>(services, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<ServiceModel> getServiceById(@PathVariable("id") Long id) {
        ServiceModel service = serviceService.findServiceById(id);
        return new ResponseEntity<>(service, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ServiceModel> addService(@RequestBody ServiceModel service) {
        ServiceModel newService = serviceService.addService(service);
        return new ResponseEntity<>(newService, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<ServiceModel> updateService(@RequestBody ServiceModel service) {
        ServiceModel updatedService = serviceService.updateService(service);
        return new ResponseEntity<>(updatedService, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteService(@PathVariable("id") Long id) {
        serviceService.deleteService(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
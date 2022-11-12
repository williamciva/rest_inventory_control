package br.com.rest.inventorycontrol.inventorycontrol;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class InventoryController {

  private final InventoryRepository repository;

  InventoryController(InventoryRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/employees")
  List<Inventory> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/employees")
  Inventory newEmployee(@RequestBody Inventory newEmployee) {
    return repository.save(newEmployee);
  }

  // Single item
  
  @GetMapping("/employees/{id}")
  Inventory one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new IvnetoryNotFoundException(id));
  }

  @PutMapping("/employees/{id}")
  Inventory replaceEmployee(@RequestBody Inventory newEmployee, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(employee -> {
        employee.setNameProd(newEmployee.getNameProd());
        return repository.save(employee);
      })
      .orElseGet(() -> {
        newEmployee.setCodProd(id);
        return repository.save(newEmployee);
      });
  }

  @DeleteMapping("/employees/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
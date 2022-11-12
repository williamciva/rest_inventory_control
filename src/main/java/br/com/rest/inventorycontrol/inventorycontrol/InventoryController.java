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
  @GetMapping("/products")
  List<Inventory> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/products")
  Inventory newInventory(@RequestBody Inventory newInventory) {
    return repository.save(newInventory);
  }

  // Single item
  
  @GetMapping("/products/{id}")
  Inventory one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new InvetoryNotFoundException(id));
  }

  @PutMapping("/products/{id}")
  Inventory replaceEmployee(@RequestBody Inventory newInventory, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(inventory -> {
        inventory.setNameProd(newInventory.getNameProd());
        return repository.save(inventory);
      })
      .orElseGet(() -> {
        newInventory.setCodProd(id);
        return repository.save(newInventory);
      });
  }

  @DeleteMapping("/products/{id}")
  void deleteEmployee(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
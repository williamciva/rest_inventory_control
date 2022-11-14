package br.com.rest.inventorycontrol.inventorycontrol;

import io.swagger.annotations.ApiOperation;

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
  @ApiOperation(
    value = "Retorna uma lista lista de todos os produtos.",
    position = 0
  )
  @GetMapping("/products")
  List<Inventory> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]



  // Single item
  @ApiOperation(
    value = "Retorna um JSON do produto informado.",
    position = 1
  )
  @GetMapping("/products/{codProd}")
  Inventory one(@PathVariable Long codProd) {
    return repository
      .findById(codProd)
      .orElseThrow(() -> new InvetoryNotFoundException(codProd));
  }



  @ApiOperation(
    value = "Insere um novo produto.",
    position = 2
  )
  @PostMapping("/products")
  Inventory newInventory(@RequestBody Inventory newInventory) {
    return repository.save(newInventory);
  }



  @ApiOperation(
    value = "Edita produtos.",
    position = 3
  )
  @PutMapping("/products/{codProd}")
  Inventory replaceEmployee(
    @RequestBody Inventory newInventory,
    @PathVariable Long codProd
  ) {
    return repository
      .findById(codProd)
      .map(inventory -> {
        inventory.setNameProd(newInventory.getNameProd());
        return repository.save(inventory);
      })
      .orElseGet(() -> {
        newInventory.setCodProd(codProd);
        return repository.save(newInventory);
      });
  }



  @ApiOperation(
    value = "Deleta um produto.",
    position = 4
  )
  @DeleteMapping("/products/{codProd}")
  void deleteEmployee(@PathVariable Long codProd) {
    repository.deleteById(codProd);
  }
}
package br.com.rest.inventorycontrol.inventorycontrol;

import org.springframework.data.jpa.repository.JpaRepository;

interface InventoryRepository extends JpaRepository<Inventory, Long> {
	
}
package labshopmonolith.infra;

import java.util.List;
import java.util.Optional;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import labshopmonolith.domain.*;
import labshopmonolith.service.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/inventories")
@Transactional
public class InventoryController {

    @Resource(name = "inventoryService")
    private InventoryService inventoryService;

    @GetMapping("/inventory")
    public List<Inventory> getAllInventories() throws Exception {
        // Get all inventories via InventoryService
        return inventoryService.getAllInventories();
    }

    @GetMapping("/inventory/{id}")
    public Optional<Inventory> getInventoryById(@PathVariable Long id)
        throws Exception {
        // Get a inventory by ID via InventoryService
        return inventoryService.getInventoryById(id);
    }

    @PostMapping("/inventory")
    public Inventory createInventory(@RequestBody Inventory inventory)
        throws Exception {
        // Create a new inventory via InventoryService
        return inventoryService.createInventory(inventory);
    }

    @PutMapping("/inventory/{id}")
    public Inventory updateInventory(
        @PathVariable Long id,
        @RequestBody Inventory inventory
    ) throws Exception {
        // Update an existing inventory via InventoryService
        return inventoryService.updateInventory(inventory);
    }

    @DeleteMapping("/inventory/{id}")
    public void deleteInventory(@PathVariable Long id) throws Exception {
        // Delete a inventory via InventoryService
        inventoryService.deleteInventory(id);
    }

    @RequestMapping(
        value = "inventory/{id}/decreasestock",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Inventory decreaseStock(
        @PathVariable(value = "id") Long id,
        @RequestBody DecreaseStockCommand decreaseStockCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        return inventoryService.decreaseStock(decreaseStockCommand);
    }
}

package labshopmonolith.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import labshopmonolith.domain.DecreaseStockCommand;
import labshopmonolith.domain.Inventory;
import labshopmonolith.domain.InventoryRepository;
import labshopmonolith.service.InventoryService;
import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("inventoryService")
@Transactional
public class InventoryServiceImpl
    extends EgovAbstractServiceImpl
    implements InventoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(
        InventoryServiceImpl.class
    );

    @Autowired
    InventoryRepository inventoryRepository;

    @Override
    public List<Inventory> getAllInventories() throws Exception {
        // Get all inventories
        return StreamSupport
            .stream(inventoryRepository.findAll().spliterator(), false)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Inventory> getInventoryById(Long id) throws Exception {
        // Get a inventory by ID
        return inventoryRepository.findById(id);
    }

    @Override
    public Inventory createInventory(Inventory inventory) throws Exception {
        // Create a new inventory
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory updateInventory(Inventory inventory) throws Exception {
        // Update an existing inventory via InventoryService
        if (inventoryRepository.existsById(inventory.getid())) {
            return inventoryRepository.save(inventory);
        } else {
            throw processException("info.nodata.msg");
        }
    }

    @Override
    public void deleteInventory(Long id) throws Exception {
        // Delete a inventory
        inventoryRepository.deleteById(id);
    }

    @Override
    public Inventory decreaseStock(DecreaseStockCommand decreaseStockCommand)
        throws Exception {
        // You can implement logic here, or call the domain method of the Inventory.

        /** Choice 1:  implement logic here        
        Optional<Inventory> optionalInventory = inventoryRepository.findById(decreaseStockCommand.getInventoryId());

        if (optionalInventory.isPresent()) {
            Inventory inventory = optionalInventory.get();
            
            // business Logic....
            inventoryRepository.save(inventory);

            return inventory;
        } else {
            throw processException("info.nodata.msg");
        }
       

        /** Choice 2:  call the domain method of the Inventory.   
        return Inventory.decreaseStock(decreaseStockCommand);
           */
    }
}

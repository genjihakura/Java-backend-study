package com.vti.bep3.service.Impl;

import com.vti.bep3.dto.MenuItemCreateDto;
import com.vti.bep3.dto.MenuItemUpdateDto;
import com.vti.bep3.entity.IngredientStore;
import com.vti.bep3.entity.IngredientUsage;
import com.vti.bep3.entity.MenuItem;
import com.vti.bep3.responsitory.IngredientRepository;
import com.vti.bep3.responsitory.IngredientUsageRepository;
import com.vti.bep3.responsitory.MenuItemRepository;
import com.vti.bep3.service.MenuItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    final MenuItemRepository menuItemRepository;
    final IngredientRepository inStore;
    final IngredientUsageRepository ingredientUsage;
    @Override
    public List<MenuItem> getAllMenu(){
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItem create(MenuItemCreateDto dto) {
        MenuItem entity = menuItemRepository.findByName(dto.getName());

        if(entity != null){
            System.out.println("Ten mon an da ton tai");
            return null;
        }
        MenuItem newDeal = new MenuItem();
        newDeal.setName(dto.getName());
        newDeal.setPrice(dto.getPrice());
        newDeal.setImageMenu(dto.getImageMenu());
        newDeal.setDescription(dto.getDescription());
        return menuItemRepository.save(newDeal);
    }

    @Override
    public void numberAvailable() {
        List<MenuItem> lsMenu = menuItemRepository.findAll();
        for (MenuItem menuItem: lsMenu) {
            List<IngredientUsage> LsingreUsages = ingredientUsage.findByMenuItemId(menuItem.getId());
            // có bao nhiêu nguyên liệu trong LsingreUsages
            // tìm số liệu nhỏ nhất trong phép tính (inStore.quantityInStock / lsingreUsages.quantityUsed)
            if(LsingreUsages != null){
                double min = 1e6;
                for (IngredientUsage ingre :  LsingreUsages) {
                    IngredientStore ItemInStore = inStore.findByName(ingre.getName());
                    if(ItemInStore != null) {
                        double scaleItem = ItemInStore.getQuantityInStock() / ingre.getQuantityUsed();
                        min = Math.min(min, scaleItem);
                    }
                //  System.out.println(min);
                }
                if (min != 1e6) {
                    menuItem.setNumberAvailable((int) min);
                    menuItemRepository.save(menuItem);
                }
            }
        }
    }

    @Override
    public MenuItem update(MenuItemUpdateDto dto) {
        int id = dto.getId();
        Optional<MenuItem> optional = menuItemRepository.findById(id);
        if (optional.isEmpty()) {
            throw new RuntimeException("Không tìm thấy món ăn có id: " + dto.getId());
        }

        MenuItem item = optional.get();
        item.setName(dto.getName());
        item.setPrice(dto.getPrice());
        //item.setUpdateDate(new Date()); // Cập nhật thời gian chỉnh sửa
        return menuItemRepository.save(item);
    }

    @Override
    public void deleteById(int id) {
        menuItemRepository.deleteById(id);
    }

    public MenuItem findByName(String name){
        MenuItem optional = menuItemRepository.findByName(name);
        if(optional == null){
            return null;
        }
        return optional;
    }
}

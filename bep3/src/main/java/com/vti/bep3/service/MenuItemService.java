package com.vti.bep3.service;

import com.vti.bep3.dto.MenuItemCreateDto;
import com.vti.bep3.dto.MenuItemUpdateDto;
import com.vti.bep3.entity.MenuItem;

import java.util.List;

public interface MenuItemService {

    List<MenuItem> getAllMenu();

    MenuItem create(MenuItemCreateDto dto);

    void numberAvailable();

    MenuItem update(MenuItemUpdateDto dto);

    void deleteById(int id);
}

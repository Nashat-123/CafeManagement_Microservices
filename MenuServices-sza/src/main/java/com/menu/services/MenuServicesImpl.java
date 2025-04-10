package com.menu.services;

import com.menu.entites.Menu;
import com.menu.repository.MenuRepository;
import com.menu.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MenuServicesImpl implements Menuservices {

    @Autowired
    private MenuRepository menuRepository;

    @Override
    public Menu create(Menu menu) {
        String menu_id = UUID.randomUUID().toString();
        menu.setMenuId(menu_id);
        return menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAll() {
        return menuRepository.findAll();
    }

    @Override
    public Menu get(String id) {
        return menuRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Menu with given id not found !!"));
    }

	@Override
	public Menu update(Menu menu) {
		
		return menuRepository.save(menu);
	}

	@Override
	public void delete(String id) {
		menuRepository.deleteById(id);
		
	}
}

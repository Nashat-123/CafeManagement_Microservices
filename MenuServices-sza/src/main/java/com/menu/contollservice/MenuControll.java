package com.menu.contollservice;

import com.menu.entites.Menu;
import com.menu.services.Menuservices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menus")
public class MenuControll {

    @Autowired
    private Menuservices menuservices;

    @PostMapping
    public ResponseEntity<Menu> createMenu(@RequestBody Menu menu) {
        return ResponseEntity.status(HttpStatus.CREATED).body(menuservices.create(menu));
    }

    @GetMapping("/{menu_id}")
    public ResponseEntity<Menu> getMenu(@PathVariable String menu_id) {
        return ResponseEntity.status(HttpStatus.OK).body(menuservices.get(menu_id));
    }

    @GetMapping
    public ResponseEntity<List<Menu>> getAllMenus() {
        return ResponseEntity.ok(menuservices.getAll());
    }
    
    @PutMapping("/{menu_id}")
    public ResponseEntity<Menu> updateMenu(@PathVariable String menu_id, @RequestBody Menu updatedMenu) {
        updatedMenu.setMenuId(menu_id); // Make sure the ID in the URL matches the ID in the request body
        Menu menu = menuservices.update(updatedMenu);
        if (menu != null) {
            return ResponseEntity.ok(menu);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{menu_id}")
    public ResponseEntity<Void> deleteMenu(@PathVariable String menu_id) {
        menuservices.delete(menu_id);
        return ResponseEntity.noContent().build();
    }
}

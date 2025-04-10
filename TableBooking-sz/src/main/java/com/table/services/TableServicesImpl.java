package com.table.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.table.entites.Tables;
import com.table.repository.TableRepository;
@Service
public class TableServicesImpl implements TableServices {

	
	 @Autowired
	    private TableRepository tableRepo;
	@Override
	public Tables create(Tables table) {
		// TODO Auto-generated method stub
		String randomUserId = UUID.randomUUID().toString();
		table.setTableId(randomUserId);
		return tableRepo.save(table);
	}

	@Override
	public List<Tables> getTables() {
		// TODO Auto-generated method stub
		return tableRepo.findAll();
	}

	@Override
	public List<Tables> GetOrderByUSerID(String userId) {
		// TODO Auto-generated method stub
		return tableRepo.findByUserId(userId);
	}

	@Override
	public List<Tables> GetOrderByMenu(String menu_id) {
		// TODO Auto-generated method stub
		return tableRepo.findByMenuId(menu_id);
	}
	@Override
    public void deleteTableById(String tableId) {
        tableRepo.deleteById(tableId);
    }

}

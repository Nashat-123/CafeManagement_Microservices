package com.table.entites;

import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "table_entities") // Use lowercase table name to avoid conflicts with SQL reserved keywords
public class Tables { // Changed class name to avoid conflicts with the reserved keyword 'Table'
    @Id
    private String tableId;
    private String userId;
    
    
    private String menuId;

	private  int tablerow;
    private  String tableNo;
    
    public Tables(String tableId, String userId, String menuId, int tablerow, String tableNo) {
		super();
		this.tableId = tableId;
		this.userId = userId;
		this.menuId = menuId;
		this.tablerow = tablerow;
		this.tableNo = tableNo;
	}

	public Tables() {
		super();
	}

	public String getTableId() {
		return tableId;
	}

	public void setTableId(String tableId) {
		this.tableId = tableId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public int getTablerow() {
		return tablerow;
	}

	public void setTablerow(int tablerow) {
		this.tablerow = tablerow;
	}

	public String getTableNo() {
		return tableNo;
	}

	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}

	@Override
	public String toString() {
		return "Tables [tableId=" + tableId + ", userId=" + userId + ", menuId=" + menuId + ", tablerow=" + tablerow
				+ ", tableNo=" + tableNo + "]";
	}
    
}

package com.user.service.dto;

public class Tables {
	private String tableId;
    private String userId;
    
    
    private String menuId;
    private Menu menu;

	private  int tablerow;
    private  String tableNo;
	public Tables(String tableId, String userId, String menuId, Menu menu, int tablerow, String tableNo) {
		super();
		this.tableId = tableId;
		this.userId = userId;
		this.menuId = menuId;
		this.menu = menu;
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
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
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
		return "Tables [tableId=" + tableId + ", userId=" + userId + ", menuId=" + menuId + ", menu=" + menu
				+ ", tablerow=" + tablerow + ", tableNo=" + tableNo + "]";
	}
    
    
}

package com.example.userclientfeign.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;

import com.example.userclientfeign.proxy.TableService;

@RestController
@Scope("request")
public class TableClientController {
	@Autowired
	private TableService tableService;
}

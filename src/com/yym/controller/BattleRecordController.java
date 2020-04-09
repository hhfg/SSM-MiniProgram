package com.yym.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.service.BattleRecordService;

@Controller
public class BattleRecordController {
	@Autowired
	private BattleRecordService battleRecordService;
	@ResponseBody
	@RequestMapping("/insRecord.do")
	public int insRecord(int playA,int playB,int status,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int result=battleRecordService.insRecord(playA, playB,status);
		//int id=battleRecordService.selId(playA, status);
		return result;
	}
	@ResponseBody
	@RequestMapping("/updRecord.do")
	public int updRecord(int playB,int status,int id,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int result=battleRecordService.updRecord(playB, status, id);
		return result;
	}
}

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
	public int insRecord(int roomid,int playA,int status,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int result=battleRecordService.insRecord(roomid,playA,status);
		return result;
	}
	
	@ResponseBody
	@RequestMapping("/updRecord.do")
	public int updRecord(int playB,int roomid,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int result=battleRecordService.updRecord(playB, roomid);
		return result;
	}
}

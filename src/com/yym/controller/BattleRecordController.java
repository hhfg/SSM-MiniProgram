package com.yym.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yym.entity.BattleRecord;
import com.yym.entity.User;
import com.yym.service.BattleRecordService;

@Controller
public class BattleRecordController {
	@Autowired
	private BattleRecordService battleRecordService;
	@ResponseBody
	@RequestMapping("/insRecord.do")
	public int insRecord(int roomid,int playA,int status,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int result=battleRecordService.insRecord(roomid,playA,status);
		if(result==1) {
			BattleRecord battleRecord=new BattleRecord();
			battleRecord.setRoomid(roomid);
			battleRecord.setPlayA(playA);
			battleRecord.setStatus(status);
			int id=battleRecordService.selId(battleRecord);
			return id;
		}else {
			return result;
		}
		
	}
	
	@ResponseBody
	@RequestMapping("/updRecord.do")
	public int updRecord(int roomid,int playB,int status,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int result=battleRecordService.updRecord(playB, status,roomid);
		if(result==1) {
			BattleRecord battleRecord=new BattleRecord();
			battleRecord.setRoomid(roomid);
			battleRecord.setPlayB(playB);
			battleRecord.setStatus(status);
			int id=battleRecordService.selId(battleRecord);
			return id;
		}
		else {
			return result;
		}
	}
	@ResponseBody
	@RequestMapping("/getUserMess.do")
	public List<User> getUserMess(int id,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		BattleRecord record=battleRecordService.selUid(id);
		int playA=record.getPlayA();
		int playB=record.getPlayB();
		List<User> list=new ArrayList<User>();
		User userA=battleRecordService.selUser(playA);
		User userB=battleRecordService.selUser(playB);
		list.add(userA);
		list.add(userB);
		return list;
	}
	@ResponseBody
	@RequestMapping("/updRoomStatus.do")
	public int updRoomStatus(int roomid,int playA,int playB,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int result=battleRecordService.updRoomStatus(1, roomid, playA, playB);
		return result;
	}
}

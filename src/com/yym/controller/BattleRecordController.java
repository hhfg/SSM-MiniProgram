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
import com.yym.entity.Records;
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
		int result=battleRecordService.updRecord(playB, status, roomid);
		System.out.println(result);
		if(result==1) {
			BattleRecord battleRecord=new BattleRecord();
			battleRecord.setRoomid(roomid);
			battleRecord.setPlayB(playB);
			battleRecord.setStatus(status);
			int id=battleRecordService.selId(battleRecord);
			return id;
		}else {
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
	public int updRoomStatus(String id,int status,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int result=battleRecordService.updRoomStatus(status,Integer.parseInt(id));
		return result;
	}
	@ResponseBody
	@RequestMapping("/updateRecord.do")
	public int updateRecord(String id,int ascore,int bscore,int status,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		System.out.println("id:"+id+",ascore:"+ascore+",bscore:"+bscore+",status:"+status);
		int result=battleRecordService.updateRecord(ascore, bscore, status, Integer.parseInt(id));
		return result;
	}
	@ResponseBody
	@RequestMapping("/selRecord.do")
	public List<Records> selRecord(int id,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		List<BattleRecord> list=battleRecordService.selRecord(id);
		List<Records> records=new ArrayList<Records>();
		for(BattleRecord b:list) {
			Records r=new Records();
			r.setPlayA(b.getPlayA());
			r.setPlayB(b.getPlayB());
			r.setAscore(b.getAscore());
			r.setBscore(b.getBscore());
			String aurl=(battleRecordService.selUser(b.getPlayA())).getAvatarUrl();
			r.setApic(aurl);
			String burl=(battleRecordService.selUser(b.getPlayB())).getAvatarUrl();
			r.setBpic(burl);
			records.add(r);
		}
		return records;
	}
	@ResponseBody
	@RequestMapping("/selUser.do")
	public User selUser(int id,HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		User u=battleRecordService.selUser(id);
		return u;
	}
}

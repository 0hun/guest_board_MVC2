package com.board.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


import com.board.action.Action;


public class ActionFactory {	
	private static ActionFactory instance = new ActionFactory();
	private ActionFactory() {		
		String path="com/board/command/command";
		this.loadProperties(path);
	}
	public static ActionFactory getInstance() {return instance;}

	// 명령어와 명령어 처리 클래스를 쌍으로 저장
	private Map<String,Action> commandMap = new HashMap<String,Action>(); 

	// properties 설정
	private void loadProperties(String path) {
		
		ResourceBundle rbHome = ResourceBundle.getBundle(path);// 누구를 실행할지를 rb에 저장.
		Enumeration<String> actionEnumHome = rbHome.getKeys();
		while (actionEnumHome.hasMoreElements())
		{
			String command = actionEnumHome.nextElement();
			String className = rbHome.getString(command);
			try {
				Class commandClass = Class.forName(className); // 해당 문자열을 클래스로 만든다
				Action commandInstance = (Action)commandClass.newInstance(); // 해당 클래스의 객체를 생성
				commandMap.put(command, commandInstance); // Map 객체인 commandMap에 객체 저장
			} catch (ClassNotFoundException e) {
				continue; // error
				// throw new ServletException(e);
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}	
	public static Action getAction(String command){
		return instance.commandMap.get(command);
	}

}







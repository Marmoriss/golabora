package com.kh.golabora.common.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import com.kh.golabora.member.model.dto.Member;

@WebListener
public class MemberLoginListener implements HttpSessionAttributeListener {

   
    public MemberLoginListener() {
        
    }

	
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         String name = se.getName();
         Object value = se.getValue();      
         
         if("loginMember".equals(name)) {
        	 Member loginMember = (Member) value;
        	 System.out.println("[회원로그인] " + loginMember.getMemberId() + " 로그인!");
         }
    }

    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	String name = se.getName();
        Object value = se.getValue();
      
        
        if("loginMember".equals(name)) {
       	 Member loginMember = (Member) value;
       	 System.out.println("[회원로그아웃] " + loginMember.getMemberId() + " 로그아웃!");
        }
    }

	
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
        
    }
	
}

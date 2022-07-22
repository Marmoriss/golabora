package com.kh.golabora.common;

public class HelloGolaboraUtils {

	public static String getPagebar(int cPage, int numPerPage, int totalContent, String url) {
		StringBuilder pagebar = new StringBuilder();
		
		//물음표 있으면, &로 연결. 없으면 ?로 연결.
		url += (url.indexOf("?") < 0) ? "?cPage=" : "&cPage=";
		
		//totalcontent / numPerPage == 0 ? totalContent / numPerPage : totalContent / numPerPage +1
		
		int totalPage = (int) Math.ceil((double)totalContent / numPerPage); 
		int pagebarSize = 5;
		int pagebarStart = ((cPage-1) / pagebarSize * pagebarSize) + 1; 
		int pagebarEnd = pagebarStart + pagebarSize - 1; 
		int pageNo = pagebarStart; 
		
		//이전영역
		//pageNo가 1일때는 없애기
		if(pageNo == 1) {
		} 
		//pageNo가 1이 아닐때 이전태그 생성
		else {
			pagebar.append("<a href='"+url + (pageNo -1) + "'>prev</a>\n"); 
		}
		
		//pageNo영역
		while(pageNo <= pagebarEnd && pageNo <= totalPage) { 
			//현재페이지 - 링크없음
			if(pageNo == cPage) {
				pagebar.append("<span class='cPage'>"+ pageNo +"</span>\n");
			}
			//현재페이지가 아닌 경우 - 링크 생성
			else {
				pagebar.append("<a href='"+ url + pageNo + "'>" + pageNo + "</a>\n");
			}
			pageNo++; 
		}
		
		//다음으로 넘어갈 페이지가 없는 경우
		if(pageNo > totalPage) {
			
		}
		//다음으로 넘어갈 페이지가 있는 경우 
		else {
			pagebar.append("<a href='"+ url + pageNo + "'>next</a>\n");
		}

		return pagebar.toString();
	}
	
	public static String convertLineFeedToBr(String str) {
		return str.replaceAll("\\n", "<br/>");
	}

	public static String escapeXml(String str) {
		//escaping 처리해주기
		return str.replaceAll("&", "&amp;")
				  .replaceAll("<", "&lt;")
				  .replaceAll(">", "&gt;");
	}
}

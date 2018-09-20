package kr.itedu.boardMVC.common;

public class Utils {
	public static int getParamInt(String p) {
		//정수 파라미터 값 가져오기(이상 있으면 -1)
		int r = -1;
		if(p !=null && !p.equals("")) {
			try {
				r = Integer.parseInt(p);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return r;
	}
}

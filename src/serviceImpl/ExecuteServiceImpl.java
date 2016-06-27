//璇蜂笉瑕佷慨鏀规湰鏂囦欢鍚�
package serviceImpl;

import java.rmi.RemoteException;

import service.ExecuteService;
import service.UserService;

public class ExecuteServiceImpl implements ExecuteService {
	/**
	 * 璇峰疄鐜拌鏂规硶
	 */
	@Override
	public String execute(String code, String param) throws RemoteException {
		// TODO Auto-generated method stub
		char[] ptr=new char[100];
		for(int i=0;i<100;i++){
			ptr[i]=0;
		}
		int point=0;
		String output="";
		int i=0;
		int[] xh=new int[20];
		int xh_c=0;
		while(i<code.length()){
				switch(code.charAt(i)){
				case ',':ptr[point]=param.charAt(0);
				         param=param.substring(1);
				         i=i+1;
				         break;
				case '.':output=output+ptr[point];
				         i=i+1;
				         break;
				case '+':ptr[point]+=1;
				         i=i+1;  
				         break;
				case '-':ptr[point]-=1;
				         i=i+1;
				         break;
				case '>':point=point+1;
				         i=i+1;
				         break;
				case '<':point=point-1;
				         i=i+1;
				         break;
				case '[':xh_c=xh_c+1;
				         xh[xh_c]=i+1;
				         i=i+1;
				         break;
				case ']':if(ptr[point]==0){
					         i=i+1;
					         xh_c=xh_c-1;
				         }
				         else{
				        	 i=xh[xh_c];
				         }
			    }
		}
		return output;
	}
}

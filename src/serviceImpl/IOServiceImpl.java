package serviceImpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;

import service.IOService;

public class IOServiceImpl implements IOService{
	@Override
	public boolean writeFile(String file, String userId, String fileName) {
		File f = new File(userId + "_" + fileName);
		Boolean tu=f.exists();
		String k=file;
		String a="";
		String m=fileName;
		String n="password";
		if(k.equals(a)||m.equals(n)){
			if(!tu){
			try {
			     f.createNewFile();
			     FileWriter fw = new FileWriter(f, false);
			     fw.write(file);
				 fw.flush();
				 fw.close();
		        } catch (IOException e) {
			         e.printStackTrace();
		        }
			}
		}
		else{
				try {FileWriter fw = new FileWriter(f, false);
					fw.write(file);
				    fw.flush();
				    fw.close();
				    } catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return tu;
	}

	@Override
	public String readFile(String userId, String fileName) {
		// TODO Auto-generated method stub
		File f = new File(userId + "_" + fileName);
		String code="";
		try {
			FileReader fr=new FileReader(f);
			BufferedReader br=new BufferedReader(fr);
			String a="";
			while((a=br.readLine())!=null){
				code=code+a;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return code;
	}
	@Override
	public boolean register(String password, String userId){
		String pw=password;
		File f=new File(userId+"_"+"password");
		Boolean tu=f.exists();
		if(tu){
			 try {FileWriter fw = new FileWriter(f, false);
				 fw.write(password);
			     fw.flush();
			     fw.close();
			 } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return tu;
	}
	@Override
	public String readFileList(String userId) {
		// TODO Auto-generated method stub
		String relativelyPath=System.getProperty("user.dir");
		File f=new File(relativelyPath);
		File[] list=f.listFiles();
		String name="";
		for(int i=0;i<list.length;i++){
			if(list[i].isFile()&&list[i].getName().split("_")[0].equals(userId)){
				name=name+list[i].getName().split("_")[1]+"\n";
			}
		}
		return name;
	}
}

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
				if(m.equals(n)){
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
				else{
					try {
						f.createNewFile();
						FileWriter fw=new FileWriter(f);
						fw.write("123");
						fw.flush();
						fw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
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
	@Override
	public String writefileline(String code,String userId,String filename){
		File f=new File(userId+"_"+filename);
		String a="";
		String m="";
		String output="";
		try {
			FileReader fr=new FileReader(f);
			BufferedReader Br=new BufferedReader(fr);
			while((a=Br.readLine())!=null){
				m=m+a;
			}
			output="1"+code+"2"+m.substring(m.indexOf("1")+1,m.indexOf("2"))+"3"+m.substring(m.indexOf("2")+1,m.indexOf("3"));
			FileWriter fw=new FileWriter(f);
			fw.write(output);
			fw.flush();
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return output;
	}
	@Override
	public String readfileline(int line,String userId,String filename){
		File f=new File(userId+"_"+filename);
		String m="";
		String a="";
		String code="";
		try {
			FileReader fr=new FileReader(f);
			BufferedReader Br=new BufferedReader(fr);
			while((a=Br.readLine())!=null){
				m=m+a;
			}
			if(line==1){
				code=m.substring(m.indexOf("1")+1,m.indexOf("2"));
			}
			if(line==2){
				code=m.substring(m.indexOf("2")+1,m.indexOf("3"));
			}
			if(line==3){
				code=m.substring(m.indexOf("3")+1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}
}

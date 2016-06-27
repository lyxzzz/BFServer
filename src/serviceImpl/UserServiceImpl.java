package serviceImpl;

import java.rmi.RemoteException;

import service.UserService;

public class UserServiceImpl implements UserService{

	@Override
	public boolean login(String username, String password) throws RemoteException {
		IOServiceImpl io=new IOServiceImpl();
		String pw=io.readFile(username, "password");
		boolean log=true;
		if(pw.equals(password)){
		      log=true;
		}
		else{
			log=false;
		}
		return log;
	}

	@Override
	public boolean logout(String username) throws RemoteException {
		return true;
	}

}

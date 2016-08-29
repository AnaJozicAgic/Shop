package shop.bo;

import shop.dto.User;

public class ValidateUser implements Validate<User> {
	
	@Override
	public boolean isValid(User object) throws ValidateException {
		
		if(!praznoNullIliManjeOdVelicine(object.getUsername(), 3)){
			throw new ValidateException("Username must bee over 3 letters");
		}
		
		if(!praznoNullIliManjeOdVelicine(object.getPassword(), 4)){
			throw new ValidateException("Password must bee over 4 letters");
		}
		
		return true;
	}
	
	private boolean praznoNullIliManjeOdVelicine(String param , int lenght){
		if(param.trim() == "" | param == null | param.length() <= lenght){
			return false;
		}
		return true;
		
	}

}

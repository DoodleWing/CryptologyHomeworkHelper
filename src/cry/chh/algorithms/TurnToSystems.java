package cry.chh.algorithms;

import java.math.BigInteger;

public class TurnToSystems {
	private String binstr, hexstr, dexstr, inputstr, startstr;
	
	public TurnToSystems(String str){
		setInputstr(str);
	}
	
	public TurnToSystems() {
		
	}
	
	private String Format(String str, int redix){
		int j = 0;
		switch (redix) {
		case 2:
			for(int i = str.length() - 1; i >= 0; i--, j++)
				if(j % 4 == 3)str = str.substring(0, i) + ' ' + str.substring(i);
			if(str.charAt(0) == ' ')str = str.substring(1);
			break;

		case 10:
			for(int i = str.length() - 1; i >= 0; i--, j++)
				if(j % 3 == 2)str = str.substring(0, i) + ',' + str.substring(i);
			if(str.charAt(0) == ',')str = str.substring(1);
			break;
			
		case 16:
			for(int i = str.length() - 1; i >= 0; i--, j++)
				if(j % 4 == 3)str = str.substring(0, i) + ' ' + str.substring(i);
			if(str.charAt(0) == ' ')str = str.substring(1);
			break;
		}
		return str;
	}

	public String TurnToBin(){
		if(startstr.equals("0b"))return(Format(inputstr, 2));
		else{
			if(startstr.equals("0d")){
				return (Format(new BigInteger(inputstr).toString(2), 2));
			}
			if(startstr.equals("0x")){
				return(Format(new BigInteger(inputstr, 16).toString(2), 2));
			}
		}
		return null;
	}
	
	public String TurnToDex(){
		if(startstr.equals("0d"))return(Format(inputstr, 10));
		else{
			if(startstr.equals("0b")){
				return(Format(new BigInteger(inputstr, 2).toString(10), 10));
			}
			if(startstr.equals("0x")){
				return (Format(new BigInteger(inputstr, 16).toString(10), 10));
			}
		}
		return null;
	}
	
	public String TurnToHex(){
		if(startstr.equals("0x"))return(Format(inputstr, 16));
		else{
			if(startstr.equals("0b")){
				return(Format(new BigInteger(inputstr, 2).toString(16).toUpperCase(), 16));
			}
			if(startstr.equals("0d")){
				return (Format(new BigInteger(inputstr).toString(16).toUpperCase(), 16));
			}
		}
		return null;
	}
	
	public void setInputstr(String inputstr) {
		this.inputstr = inputstr;
		startstr = new String(this.inputstr.substring(0, 2));
		this.inputstr = inputstr.substring(2);
	}
}

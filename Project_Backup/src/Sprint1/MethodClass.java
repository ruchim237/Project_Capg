package Sprint1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;
import Sprint1.MethodClass;
public class MethodClass implements Health_Care_System{
	static int i=0;
    public static HashMap<Integer,User> users=new HashMap<>();
	public static ArrayList<String> centers;
	 public boolean validationPassword(String pass){
	        Boolean valid=true;
	        int digit=0,special_charcters=0,alphabet=0;
	        if(pass.length()<8 || pass.length()>=14){
	            valid=false;
	        }else {
	            for(int i=0;i<pass.length();i++){
	                char c=pass.charAt(i);
	                if(c>=48 && c<=57 ){
	                    digit++;
	                }
	                if((c>=65 && c<=90) || (c>=97 && c<=122)){
	                    alphabet++;
	                }
	                else if((c>=32 && c<=47) || (c>=58 && c<=64) || (c>=91 && c<=96) || (c>=123 && c<=126))
	                {
	                    special_charcters++;
	                }
	            }
	            if(digit==0 || special_charcters==0 || alphabet==0){
	                valid=false;
	            }
	        }
	        return valid;
	 }
	 public boolean validationNumber(String num){
	        Boolean numvalid=true;
	            if (num.charAt(0)=='0' || !(num.length()==10)){
	                numvalid=false;
	            }
	               
	            else
	                {for(int i=1;i<num.length();i++){
	                if(!(num.charAt(i)>=48 && num.charAt(i)<=57)){
	                    numvalid=false;   
	                }
	            }
	        }
	        return numvalid;
	    }
	 public boolean validationName(String name)
	 {
		 boolean validname=true;
         if(!(name.charAt(0)>=65 && name.charAt(0)<=90)){
           validname=false;
         }else 
         {
        	 for(int i=1;i<name.length();i++)
        	 {
        		 if(!(name.charAt(i)>=97 && name.charAt(i)<=122))
        		 {
        			 validname=false;
        			 
        		 }
        	 }
         }
		return validname;
	 }
	 public  boolean EmailValid(String email) 
	    { 
	        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
	                            "[a-zA-Z0-9_+&*-]+)*@" + 
	                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
	                            "A-Z]{2,7}$"; 
	                              
	        Pattern pat = Pattern.compile(emailRegex); 
	        if (email == null) 
	            return false; 
	        return pat.matcher(email).matches(); 
	    } 
	  	 public  void register(){
	     try{	            
	    	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	            System.out.println("Enter The Name");
	            System.out.println("Tip: Name should not start with special characters and should not be blank. First letter should be capital");
	            String name=br.readLine();
	            if(!(validationName(name)))
	            {
	                do{
	                	System.out.println("Name Rule is voilated :");
	                    System.out.println("Enter The Name Again");
	                    name=br.readLine();
	                }while(!(validationName(name)));
	                }
	            
	             System.out.println("Enter The Mobile No");
	            System.out.println("Tip: Number Length Should be 10 digits and starting digit shouldn't be zero");
	            String num=br.readLine();
	            if(!validationNumber(num)){
	            do{
                     System.out.println("The Mobile number Rule Is Violated");
                    System.out.println("Enter The Mobile No Again");
	                num=br.readLine();
	            }while(!validationNumber(num));
	            }  
	            BigInteger mobNo=new BigInteger(num);
	            System.out.println("Enter The Password");
	            System.out.println("Tip: Password must contain one number,one alphabet,one special character and size should be at least 8 characters and not more than 14 characters");
	            String pass=br.readLine();
	            if(!validationPassword(pass)){
	                do{
	                    System.out.println("The Password Rule Is Violated");
	                    System.out.println("Enter The Password Again");
	                    pass=br.readLine();
	                }while(!validationPassword(pass));
	           }
	            
	            System.out.println("Enter The Email ID");
	            String emailId=br.readLine();
	            if(!EmailValid(emailId)){
		            do{
		                System.out.println("The EmailID  Rule Is Violated");
		                System.out.println("Enter The EmailID  Again");
		                emailId=br.readLine();
		            }while(!EmailValid(emailId));
		            }
	            User u1 = new User(name,pass, emailId, mobNo);
	           users.put(i++,u1);
	           System.out.println("Thank You For Registering");
	           System.out.println("Your user id is :"+(i-1));
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	 
	 public String AdminLogin()
	 {     
		 String loginAdmin="";
	 try{			 
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 System.out.println("Enter The Admin Id");
         String id=br.readLine();
         System.out.println("Enter The Admin Password");
         String pass=br.readLine();
         if((id.equals("admin")) && pass.equals("password"))
         {
             loginAdmin= "\nLogin Successful\nAdmin can do further work of admin \n";
         }     
          else
         {
        	  throw new LoginWrongException("Credential Wrong : Please Try Again");
         }
        }catch(LoginWrongException e) {
	            System.out.println(e);
	        } catch (IOException e) {
			e.printStackTrace();
		}
	return loginAdmin;
	 }
	 

}

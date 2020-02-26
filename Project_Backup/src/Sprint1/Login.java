package Sprint1;
import Sprint1.MethodClass;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
public class Login {
	public static void main(String args[]) 
	{		 MethodClass obj=new MethodClass();
		try
		{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Boolean OuterExit=false;	
		 do{
             System.out.println("Enter 1 for Admin");
             System.out.println("Enter 2 for Customer");
             System.out.println("Enter 3 for Exit");
             char ch=br.readLine().charAt(0);
             switch(ch)
             {
                 case '1':String result=obj.AdminLogin();
                          System.out.println(result);
                          break;
                 case '2':
                     Boolean custExit=false;
                     do{
                         System.out.println("Enter 1 for New User");
                         System.out.println("Enter 2 for Existing User");
                         System.out.println("Enter 3 for Exiting The Menu ");
                         char ch2=br.readLine().charAt(0);                
                         switch(ch2)
                                {
                             case '1':obj.register();
                                 break;
                             case '2':
                                     System.out.println("Enter The User Id");
                                     String uId=br.readLine();
                                     System.out.println("Enter The User Password");
                                     String uPass=br.readLine();
                                     int found=0;
                                      for (Map.Entry<Integer,User> u : obj.users.entrySet())   
                                     {
                                    	  
                                         if(u.getValue().getUserId().equals(uId) && u.getValue().getUserPassword().equals(uPass))
                                         {
                                        	 System.out.println("User Exist : Successful Login");
                                             found=1;
                                             break;
                                         }
                                       }
                                        if (found==0)
                                       {
                                         System.out.println("Credential Wrong : please try Again");
                                         break;
                                        }
                                     break;
                               case '3':System.out.println("Exiting from User Menu");
                                     custExit=true;
                                     break;
                                     default: System.out.println("Wrong Choice");
                                  }
                                }while(!custExit);
                                      break;
                           case '3':
         	                      System.out.println("Exiting From The System\n Good Bye!");
         	                       OuterExit=true;
         	                       break;
         	             default:
         	                     throw new InvalidChoiceException("Wrong choice");
         	                 }
         	        }while(!OuterExit);
               }
		    catch (Exception e) 
                   {
         	        System.out.println(e);       	      
		           } 
		}
	
}


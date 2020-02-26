package Sprint1;

import Sprint1.MethodClass;
import java.math.BigInteger;
import java.util.ArrayList;

public class User{
	MethodClass m=new MethodClass();
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public BigInteger getContactNo() {
		return contactNo;
	}
	public void setContactNo(BigInteger contactNo) {
		this.contactNo = contactNo;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
		public String getUserId() {
			return userId;
		
	}
    static int ustart=0;
    String userRole;
    private String userPassword;
	private String userName;
	private String emailId;
	private String userId;
    private BigInteger contactNo;
    ArrayList<String>centerList=new ArrayList<>();
    public User(String userName,String userPassword,String emailId,BigInteger contactNo){
        this.userPassword=userPassword;
        this.userName=userName;
        this.emailId=emailId;
        this.contactNo=contactNo;
        this.userId=Integer.toString(ustart++);
        this.userRole="Customer";
      //  this.centerList=m.centers;
    }
    public User(String userName,String userPassword,String emailId,BigInteger contactNo,String userRole){
        this.userPassword=userPassword;
        this.userName=userName;
        this.emailId=emailId;
        this.contactNo=contactNo;
        this.userId=Integer.toString(ustart++);
        this.userRole=userRole;
     //   this.centerList=m.centers;
    }

	
}

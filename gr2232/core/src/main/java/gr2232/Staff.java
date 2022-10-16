package gr2232;

public class Staff{
  private String status;
  private String username;
  private String password;

  /*public Staff(String status, String username, String password){
    this.status = status;
    this.username = username;
    this.password = password;
  }*/

  public String getStatus(){
    return status;
  }

  public String getUsername(){
    return username;
  }

  public String getPassword(){
    return password;
  }

  public void setStatus(String status) {
    if(status == "Manager" || status == "Employee"){
      this.status = status;
    }
  }
} 
package gr2232.core;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Unit {

  private boolean isRented = false;
  private String customerName = "null";
  private Integer location;
  private char size;

  @JsonCreator
  public Unit(@JsonProperty("size") char size, 
  @JsonProperty("location") Integer location,
  @JsonProperty("isRented") Boolean isRented,
  @JsonProperty("customerName") String customername) {
     setSize(size);
    setLocation(location);
    setCustomerName(customername);
    setIsRented(isRented); 
  }

  public Unit(char size, Integer location) {
    setSize(size);
    setLocation(location);
  }

  public void setSize(char size) {
        // Check if valid size
        if (size == 'S' || size == 'M' || size == 'L') {
            this.size = size;
        } else {
            throw new IllegalArgumentException("Unit size must either be S,M or L!");
        }
    }

  public char getSize() {
    return this.size;
  }

    public boolean getIsRented() {
        return this.isRented;
    }

  // Toggles isRented boolean
  public void toggleIsRented() {
    // Encapsulate customername, remove name is state is set to not rented
    if (getIsRented()) { 
      setCustomerName("null");
    }
    this.isRented = !this.isRented;
  }

  public void removeTenantFromUnit() {
    if (getIsRented()) { 
      setCustomerName("null");
      setIsRented(false); 
    } else {
      throw new IllegalArgumentException("The unit does not have a tenant!");
    }
  }

  public void setIsRented(boolean b) { 
    if(!b) {
      setCustomerName("null");
    }
    this.isRented = b; 
  }


  public void setCustomerName(String name) {
    if (getIsRented() == false) {
      toggleIsRented();
      this.customerName = name;
    } else {
      // Do not toggle, changing customer to the unit
      this.customerName = name;
    }
  }

  public String getCustomerName() {
    return this.customerName;
  }

  public Integer getLocation() {
    return this.location;
  }

  public void setLocation(Integer loc) {
    this.location = loc;
  }

  public void setUnitFree() {
    if (getIsRented()) {
      toggleIsRented();
    }
  }

}

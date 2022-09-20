package gr2232;

public class Unit {

    private boolean isRented = false;
    private String customerName;
    private Integer location;
    private char size;

    public Unit(char size, Integer location) {
        setSize(size);
        setLocation(location);
    }

    public void setSize(char size) {
        //Check if valid size
        if (size == 'S' || size == 'M' || size == 'L') {
            this.size = size;
        }
        else {
            throw new IllegalArgumentException("Unit size must either be S,M or L!");
        }  
    }

    public char getSize() {
        return this.size;
    }


    public boolean getIsRented(){
        return this.isRented;
    }

    //Toggles isRented boolean
    public void toggleIsRented() {
        //Encapsulate customername, remove name is state is set to not rented
        if (getIsRented()) {
            setCustomerName("null");
        }
        this.isRented = !this.isRented;
    }


    public void setCustomerName(String name) {
        /* if (getIsRented()) {
            this.customerName = name;
        }
        else {
            throw new IllegalStateException("Cannot set customername when the unit is not rented!");
        } */
        if (getIsRented() == false) {
            toggleIsRented();
            this.customerName = name;
        }
        else {
            //Do not toggle, changing customer to the unit
            this.customerName = name;
        }
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public Integer getLocation() {
        return this.location;
    }

    //UnitList will get the location when added. Atleast what I have in mind atm
    public void setLocation(Integer loc) {
        this.location = loc;
    }

    public void setUnitFree() {
        if (getIsRented()) {
            toggleIsRented();
        }
        setCustomerName("null");
    }

    //Testing/debugging
    public static void main(String args[]) {
        Unit test = new Unit('M',0);
        System.out.println(test.getSize());
        test.setSize('L');
        System.out.println(test.getSize());
        
        //Throws exception as planned
        //test.setSize('R');

        System.out.println(test.getIsRented());
        //Throws exception as planned
        //Must set state to rented before setting customer name
        //test.setCustomerName("Magnus Svendsen");

    }


}

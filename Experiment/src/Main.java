package model;

public class Main {
    public static void main(String[] args) {
        // CREATE CUSTOMER ARRAY AND INITIALIZE CUSTOMER OBJECTS
        int i = 0;
        Customer[] cust_array;
        cust_array = new Customer[5];
        while (i < 5) {
            cust_array[i] = new Customer();
            i++;
        }

        // SET CUSTOMER NAMES AND IDs
        cust_array[0].setCustomer_name("Rahul");
        cust_array[1].setCustomer_name("Ramesh");
        cust_array[2].setCustomer_name("Harsh");
        cust_array[3].setCustomer_name("Abdulla");
        cust_array[4].setCustomer_name("Sanjay");

        cust_array[0].setCustomer_id(101);
        cust_array[1].setCustomer_id(536);
        cust_array[2].setCustomer_id(215);
        cust_array[3].setCustomer_id(426);
        cust_array[4].setCustomer_id(373);

        // SET CUSTOMER PHONE NUMBERS
        cust_array[0].setPhone_no("9452648558");
        cust_array[1].setPhone_no("8459512354");
        cust_array[2].setPhone_no("7642648558");
        cust_array[3].setPhone_no("8445648558");
        cust_array[4].setPhone_no("9452648558");

        // CREATE ELECTRONIC DEVICE ARRAY AND INITIALIZE DEVICE OBJECTS
        int j = 0;
        Electronic_Device[] Dev_array;
        Dev_array = new Electronic_Device[5];
        while (j < 5) {
            Dev_array[j] = new Electronic_Device();
            j++;
        }

        // SET DEVICE NAMES AND PRICES
        Dev_array[0].setDevice_Name("Mobile");
        Dev_array[1].setDevice_Name("AC");
        Dev_array[2].setDevice_Name("TV");
        Dev_array[3].setDevice_Name("Laptop");
        Dev_array[4].setDevice_Name("Refrigerator");

        Dev_array[0].setDevice_Price(18000);
        Dev_array[1].setDevice_Price(28000);
        Dev_array[2].setDevice_Price(42000);
        Dev_array[3].setDevice_Price(50000);
        Dev_array[4].setDevice_Price(34000);

        // CREATE BRAND ARRAY AND INITIALIZE BRAND OBJECTS
        int m = 0;
        Brand[] Brand_array;
        Brand_array = new Brand[5];
        while (m < 5) {
            Brand_array[m] = new Brand();
            m++;
        }

        // SET BRAND NAMES
        Brand_array[0].setBrand_Name("Samsung");
        Brand_array[1].setBrand_Name("Apple");
        Brand_array[2].setBrand_Name("LG");
        Brand_array[3].setBrand_Name("Lenovo");
        Brand_array[4].setBrand_Name("Voltas");

        // CREATE PURCHASES ARRAY AND INITIALIZE PURCHASES OBJECTS
        int k = 0;
        purchases[] purchases_array;
        purchases_array = new purchases[10];
        while (k < 5) {
            purchases_array[k] = new purchases();
            k++;
        }

        // PERFORM PURCHASES AND SET ASSOCIATED DEVICE, CUSTOMER, AND BRAND DETAILS
        purchases_array[0].purchases_objDev_objCust(Dev_array[0], cust_array[0], Brand_array[1]);
        purchases_array[1].purchases_objDev_objCust(Dev_array[4], cust_array[2], Brand_array[2]);
        purchases_array[2].purchases_objDev_objCust(Dev_array[2], cust_array[4], Brand_array[0]);
        purchases_array[3].purchases_objDev_objCust(Dev_array[3], cust_array[3], Brand_array[3]);
        purchases_array[4].purchases_objDev_objCust(Dev_array[1], cust_array[4], Brand_array[4]);

        // DISPLAY PURCHASE DETAILS FOR EACH PURCHASE
        purchases_array[0].display_ELectronic_Device_Customer();
        purchases_array[1].display_ELectronic_Device_Customer();
        purchases_array[2].display_ELectronic_Device_Customer();
        purchases_array[3].display_ELectronic_Device_Customer();
        purchases_array[4].display_ELectronic_Device_Customer();
    }
}

import Model.Brand;
import Model.Electronic_Device;
import Model.Customer;
import Model.purchases;

import java.util.Calendar;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Customer[] cust_array;
        cust_array = new Customer[5];
        cust_array[0] = new Customer();
        cust_array[1] = new Customer();
        cust_array[2] = new Customer();
        cust_array[3] = new Customer();
        cust_array[4] = new Customer();

//        cust_array[0].setName("StudName0");
//        cust_array[1].setName("StudName1");
//        cust_array[2].setName("StudName2");
//        cust_array[3].setName("StudName3");
//        cust_array[4].setName("StudName4");

        Electronic_Device[] Electronic_Device_array;
        Electronic_Device_array = new Electronic_Device[5];
        Electronic_Device_array[0] = new Electronic_Device();
        Electronic_Device_array[1] = new Electronic_Device();
        Electronic_Device_array[2] = new Electronic_Device();

        Electronic_Device_array[0].setDevice_Name("AC");
        Electronic_Device_array[1].setDevice_Name("TV");
        Electronic_Device_array[2].setDevice_Name("Refridgerator");

        Brand[] Brand_array;
        Brand_array = new Brand[5];
        Brand_array[0] = new Brand();
        Brand_array[1] = new Brand();
        Brand_array[2] = new Brand();

        int[][] purchases_array_2d = new int[10][2];

        purchases[] purchases_array;
        purchases_array = new purchases[10];
        purchases_array[0] = new purchases();
        purchases_array[1] = new purchases();
        purchases_array[2] = new purchases();
        purchases_array[3] = new purchases();
        purchases_array[4] = new purchases();
        purchases_array[5] = new purchases();
        purchases_array[6] = new purchases();
        purchases_array[7] = new purchases();
        purchases_array[8] = new purchases();
        purchases_array[9] = new purchases();

        purchases_array[0].purchases_objDev_objCust(cust_array[0],Electronic_Device_array[1],Brand_array[1]);
        purchases_array[1].purchases_objDev_objCust(cust_array[2],Electronic_Device_array[1],Brand_array[1]);
        purchases_array[2].purchases_objDev_objCust(cust_array[1],Electronic_Device_array[2],Brand_array[1]);
        purchases_array[3].purchases_objDev_objCust(cust_array[3],Electronic_Device_array[1],Brand_array[1]);
        purchases_array[4].purchases_objDev_objCust(cust_array[1],Electronic_Device_array[0],Brand_array[1]);
        purchases_array[5].purchases_objDev_objCust(cust_array[4],Electronic_Device_array[0],Brand_array[1]);
        purchases_array[6].purchases_objDev_objCust(cust_array[0],Electronic_Device_array[0],Brand_array[1]);
        purchases_array[7].purchases_objDev_objCust(cust_array[2],Electronic_Device_array[2],Brand_array[1]);
        purchases_array[8].purchases_objDev_objCust(cust_array[2],Electronic_Device_array[1],Brand_array[1]);
        purchases_array[9].purchases_objDev_objCust(cust_array[3],Electronic_Device_array[2],Brand_array[1]);

        purchases_array[0].display_ELectronic_Device_Customer();
        purchases_array[1].display_ELectronic_Device_Customer();
        purchases_array[2].display_ELectronic_Device_Customer();
        purchases_array[3].display_ELectronic_Device_Customer();
        purchases_array[4].display_ELectronic_Device_Customer();
        purchases_array[5].display_ELectronic_Device_Customer();
        purchases_array[6].display_ELectronic_Device_Customer();
        purchases_array[7].display_ELectronic_Device_Customer();
        purchases_array[8].display_ELectronic_Device_Customer();
        purchases_array[9].display_ELectronic_Device_Customer();

        for (int i = 0; i <= 10; i++)
        {
            int Customer_id = purchases_array_2d[i][0];
            int Electronic_Device_id = purchases_array_2d[i][1];
            System.out.println();
        }
    }
}
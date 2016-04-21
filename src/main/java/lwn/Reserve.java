package lwn;

import Module.Hotel;
import Module.ReserveHotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
;
import java.util.Date;
import java.util.HashSet;


public class Reserve {

    public static void main(String args[]) {
        String customerType = "";
        HashSet<Date> reserveDates = null;
        if (args.length > 0) {
            String inputArray[] = args[0].split(":");
            if (inputArray.length > 1) {
                customerType = inputArray[0];
                reserveDates = getDates(inputArray[1]);
                if (reserveDates != null) {
                    System.out.println("For Customer : " + customerType);
                    System.out.println("For dates : " + reserveDates.toString());
                    Hotel cheapestHotel = ReserveHotel.getCheapestHotel(customerType, reserveDates);
                    if (cheapestHotel != null) {
                        System.out.println("Cheapest Hotel Details Are : ");
                        cheapestHotel.printDetails();
                    }
                } else {
                    System.out.println("Please Enter Correct Date Input...");
                }
            } else {
                System.out.println("Please Enter Date Input...");
            }
        } else {
            System.out.println("Please Enter Customer Type and Date Input...");
        }
    }

    private static HashSet<Date> getDates(String inputDate) {
        HashSet<Date> dateSet = new HashSet<Date>();
        String dateArray[] = inputDate.split(",");
        SimpleDateFormat formatterObj = new SimpleDateFormat("ddMMMyyyy(EEE)");
        for (String date : dateArray) {
            try {
                Date newDate = formatterObj.parse(date);
                dateSet.add(newDate);
            } catch (ParseException e) {
                e.printStackTrace();
                return null;
            }
        }
        return dateSet;

    }
}
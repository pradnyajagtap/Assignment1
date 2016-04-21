package Module;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;


public class ReserveHotel {

    private static final int MAXRATE = 999999999;

    public static Hotel getCheapestHotel(String customerType, HashSet<Date> allDates) {
        HashSet<Hotel> allHotels = getAllHotelDetails();
        allHotels = setTotalRate(customerType, allDates, allHotels);
        return (compareHotels(allHotels));
    }

    private static HashSet<Hotel> getAllHotelDetails() {
        HashSet<Hotel> hotelSet = new HashSet<Hotel>();
        Hotel hotelObj;
        hotelObj = new Hotel("SWN Star Hotel", 3);
        hotelObj.set_regularWeekdayRate(1000);
        hotelObj.set_rewardWeekdayRate(800);
        hotelObj.set_regularWeekendRate(1500);
        hotelObj.set_rewardWeekendRate(1250);
        hotelSet.add(hotelObj);
        hotelObj = new Hotel("SWN Deluxe Hotel", 4);

        hotelObj.set_regularWeekdayRate(2000);
        hotelObj.set_rewardWeekdayRate(1500);
        hotelObj.set_regularWeekendRate(1500);
        hotelObj.set_rewardWeekendRate(1200);
        hotelSet.add(hotelObj);
        hotelObj = new Hotel("SWN Executive Hotel", 5);
        hotelObj.set_regularWeekdayRate(3000);
        hotelObj.set_rewardWeekdayRate(2500);
        hotelObj.set_regularWeekendRate(2500);
        hotelObj.set_rewardWeekendRate(2200);
        hotelSet.add(hotelObj);
        return hotelSet;
    }

    private static HashSet<Hotel> setTotalRate(String customerType, HashSet<Date> allDates, HashSet<Hotel> allHotels) {
        int totalWeekday = 0, totalWeekend = 0;
        for (Date currentDate : allDates) {
            Calendar c = Calendar.getInstance();
            c.setTime(currentDate);
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            if (dayOfWeek >= Calendar.MONDAY && dayOfWeek <= Calendar.FRIDAY) {
                totalWeekday++;
            } else {
                totalWeekend++;
            }
        }
        for (Hotel hotelObj : allHotels) {
            hotelObj.set_totalRate(customerType, totalWeekday, totalWeekend);
            hotelObj.printDetails();
        }
        return allHotels;
    }

    private static Hotel compareHotels(HashSet<Hotel> allHotels) {
        int lowRate = MAXRATE;
        Hotel outputHotel = null;
        for (Hotel hotelObj : allHotels) {
            int hotelRate = hotelObj.get_totalRate();
            if (hotelRate <= lowRate) {
                if (hotelRate == lowRate) {

                    outputHotel = checkHighestRating(hotelObj, outputHotel);

                } else {

                    outputHotel = hotelObj;
                }
                lowRate = outputHotel.get_totalRate();
            }
        }
        return outputHotel;
    }

    private static Hotel checkHighestRating(Hotel hotelObj, Hotel outputHotel) {
        if (hotelObj.get_rating() > outputHotel.get_rating()) {
            return hotelObj;
        } else {
            return outputHotel;
        }
    }

}

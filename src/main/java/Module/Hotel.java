package Module;

public class Hotel {
    private int _rating;
    private String _hotelName;
    private int _regularWeekdayRate;
    private int _regularWeekendRate;
    private int _rewardWeekdayRate;
    private int _rewardWeekendRate;
    private int _totalRate;

    public int get_rating() {
        return _rating;
    }

    public void set_rating(int _rating) {
        this._rating = _rating;
    }

    public String get_hotelName() {
        return _hotelName;
    }

    public void set_hotelName(String _hotelName) {
        this._hotelName = _hotelName;
    }

    public int get_regularWeekdayRate() {
        return _regularWeekdayRate;
    }

    public void set_regularWeekdayRate(int _regularWeekdayRate) {
        this._regularWeekdayRate = _regularWeekdayRate;
    }

    public int get_regularWeekendRate() {
        return _regularWeekendRate;
    }

    public void set_regularWeekendRate(int _regularWeekendRate) {
        this._regularWeekendRate = _regularWeekendRate;
    }

    public int get_rewardWeekdayRate() {
        return _rewardWeekdayRate;
    }

    public void set_rewardWeekdayRate(int _rewardWeekdayRate) {
        this._rewardWeekdayRate = _rewardWeekdayRate;
    }

    public int get_rewardWeekendRate() {
        return _rewardWeekendRate;
    }

    public void set_rewardWeekendRate(int _rewardWeekendRate) {
        this._rewardWeekendRate = _rewardWeekendRate;
    }

    public int get_totalRate() {
        return _totalRate;
    }

    public void set_totalRate(String customerType,int totalWeekday,int totalWeekend) {
        if(customerType.equalsIgnoreCase("regular"))
        {
            this._totalRate = (totalWeekday *_regularWeekdayRate) + (totalWeekend * _regularWeekendRate);
        }
        else if(customerType.equalsIgnoreCase("reward"))
        {
            this._totalRate = (totalWeekday * _rewardWeekdayRate) + (totalWeekend * _rewardWeekendRate);
        }
    }

    public void printDetails() {
        System.out.println("Name : "+_hotelName);
        System.out.println("Rating : "+_rating);
        System.out.println("Total rate : "+_totalRate);
    }
}

public class Man {
    Activity activity;


    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String executeActivity() {
        return activity.justDoit();
    }
}

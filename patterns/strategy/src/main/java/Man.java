public class Man {
   private Activity activity;

     void setActivity(Activity activity) {
        this.activity = activity;
    }

     String executeActivity() {
        return activity.justDoIt();
    }
}

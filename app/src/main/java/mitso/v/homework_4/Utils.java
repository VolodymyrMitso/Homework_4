package mitso.v.homework_4;

import android.app.Activity;
import android.content.Intent;


public class Utils
{
    private static int sTheme;

    public final static int THEME_1 = 1;
    public final static int THEME_2 = 2;

    /**
     * Set the theme of the Activity, and restart it by creating a new Activity
     * of the same type.
     */
    public static void changeToTheme(Activity activity, int theme)
    {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    /** Set the theme of the activity, according to the configuration. */
    public static void onActivityCreateSetTheme(Activity activity)
    {
        switch (sTheme)
        {
            default:
            case THEME_1:
                activity.setTheme(R.style.AppTheme1);
                break;
            case THEME_2:
                activity.setTheme(R.style.AppTheme2);
                break;
        }
    }
}

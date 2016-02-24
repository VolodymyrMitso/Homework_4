package mitso.v.homework_4;

import android.app.Activity;
import android.content.Intent;

public class ThemesUtils {

    private static int sTheme;

    public final static int THEME_LIGHT = 1;
    public final static int THEME_DARK = 2;

    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));
    }

    public static void onActivityCreateSetTheme(Activity activity) {

        switch (sTheme) {
            case THEME_LIGHT:
                activity.setTheme(R.style.thm_LightTheme);
                break;
            case THEME_DARK:
                activity.setTheme(R.style.thm_DarkTheme);
                break;
        }
    }

    public static void initViews() {
        MainActivity.firstButton.setText(MainActivity.firstNumberString);
        MainActivity.secondButton.setText(MainActivity.secondNumberString);
        MainActivity.signEditText.setText(MainActivity.signString);
        MainActivity.resultView.setText(MainActivity.resultString);
    }
}

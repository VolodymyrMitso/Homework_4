package mitso.v.homework_4;

import android.app.Activity;
import android.content.Intent;

public class ThemesUtils {

    private static int theme_index;

    public final static int THEME_LIGHT = 1;
    public final static int THEME_DARK = 2;

    public static void changeToTheme(Activity activity, int theme) {
        theme_index = theme;
        activity.finish();
        activity.startActivity(new Intent(activity, activity.getClass()));

        MainActivity.string_sign = String.valueOf(MainActivity.editText_sign.getText());
    }

    public static void onActivityCreateSetTheme(Activity activity) {
        switch (theme_index) {
            case THEME_LIGHT:
                activity.setTheme(R.style.thm_LightTheme);
                break;
            case THEME_DARK:
                activity.setTheme(R.style.thm_DarkTheme);
                break;
        }
    }

    public static void initViews() {
        MainActivity.button_first.setText(MainActivity.string_firstNumber);
        MainActivity.button_second.setText(MainActivity.string_secondNumber);
        MainActivity.editText_sign.setText(MainActivity.string_sign);
        MainActivity.textView_result.setText(MainActivity.string_result);
    }
}

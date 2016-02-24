package mitso.v.homework_4;

import android.content.Context;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

public class FirstSupport {

    private static Context context;
    private static String string;

    public static boolean check(EditText editText, Context c) {

        String s1 = String.valueOf(editText.getText());
        boolean result = false;
        context = c;

        if (s1.isEmpty()) {
            showToast(Constants.WARNING_FIRST_EMPTY);
        } else {
            if (!isStringADouble(s1)) {
                showToast(Constants.WARNING_FIRST_INCORRECT_INPUT);
            } else {
                if (!s1.contains("."))
                    s1 += ".0";
                if (s1.length() > 3) {
                    showToast(Constants.WARNING_FIRST_TOO_LONG);
                } else {
                    result = true;
                    string = s1;
                }
            }
        }
        return result;
    }

    public static String returnString() {
        return string;
    }

    private static void showToast(String warning) {
        Toast toast = Toast.makeText(context, warning, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.LEFT,0,-500);
        toast.show();
    }

    private static boolean isStringADouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

package mitso.v.homework_4;

import android.content.Context;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.Toast;

public class SecondSupport {

    private static Context context;
    private static String string;

    public static boolean check(EditText editText, Context c) {

        String s2 = String.valueOf(editText.getText());
        boolean result = false;
        context = c;

        if (s2.isEmpty()) {
            showToast(Constants.WARNING_SECOND_EMPTY);
        } else {
            if (!isStringADouble(s2)) {
                showToast(Constants.WARNING_SECOND_INCORRECT_INPUT);
            } else {
                if (!s2.contains("."))
                    s2 += ".0";
                if (s2.length() > 3) {
                    showToast(Constants.WARNING_SECOND_TOO_LONG);
                } else {
                    result = true;
                    string = s2;
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
        toast.setGravity(Gravity.RIGHT,0,-500);
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

package mitso.v.homework_4;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainSupport {

    private static Context context;

    public static void calculate(String s1, String s2, Context c) {

        context = c;

        if (s1.isEmpty() && s2.isEmpty()) {
            showToast(Constants.WARNING_BOTH_EMPTY);
        } else if (s1.isEmpty()) {
            showToast(Constants.WARNING_FIRST_EMPTY);
        } else if (s2.isEmpty()) {
            showToast(Constants.WARNING_SECOND_EMPTY);
        } else {
            String sign = String.valueOf(MainActivity.signEditText.getText());
            MainActivity.signString = sign;///////////////////////////////////////////////////////////////////////
            if (sign.isEmpty()) {
                showToast(Constants.WARNING_SIGN_EMPTY);
            } else {
                if (!isSignCorrect(sign)) {
                    showToast(Constants.WARNING_SIGN_INCORRECT_INPUT);
                } else {
                    double d1 = Double.parseDouble(s1);
                    double d2 = Double.parseDouble(s2);
                    double result = 0.0;
                    if (sign.equals("+"))
                        result = d1 + d2;
                    else if (sign.equals("-"))
                        result = d1 - d2;
                    else if (sign.equals("*"))
                        result = d1 * d2;
                    else if (sign.equals("/")) {
                        result = d1 / d2;
                        result = new BigDecimal(result).setScale(2, RoundingMode.HALF_UP).doubleValue();
                    }
                    MainActivity.resultString = String.valueOf(result); ////////////////////////////////////////////////////////
                    MainActivity.resultView.setText(String.valueOf(result));
                }
            }
        }
    }

    private static void showToast(String warning) {
        Toast toast = Toast.makeText(context, warning, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,-500);
        toast.show();
    }

    private static boolean isSignCorrect(String s) {
        return
                s.matches("\\+") ||
                s.matches("-") ||
                s.matches("\\*") ||
                s.matches("/");

    }
}

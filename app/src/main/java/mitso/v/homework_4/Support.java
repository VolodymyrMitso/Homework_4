package mitso.v.homework_4;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

public class Support {

    private static Context context;

    private static final String WARNING_FIRST_EMPTY = "there is no first number:\n".toUpperCase() +
            "- press first button to enter first number";

    private static final String WARNING_SECOND_EMPTY = "there is no second number:\n".toUpperCase() +
            "- press second button to enter second number";

    private static final String WARNING_BOTH_EMPTY = "there are no numbers:\n".toUpperCase() +
            "- press first button to enter first number\n" +
            "- press second button to enter second number";

    private static final String WARNING_BOTH_INCORRECT_INPUT = "incorrect input - both numbers:\n".toUpperCase() +
            "- use only these symbols [1234567890.]\n" +
            "- press first button to enter first number\n" +
            "- press second button to enter second number";

    private static final String WARNING_FIRST_INCORRECT_INPUT = "incorrect input - first number:\n".toUpperCase() +
            "- use only these symbols [1234567890.]\n" +
            "- press first button to enter first number\n";


    private static final String WARNING_SECOND_INCORRECT_INPUT = "incorrect input - second number:\n".toUpperCase() +
            "- use only these symbols [1234567890.]\n" +
            "- press second button to enter second number\n";

    private static final String WARNING_BOTH_TOO_LONG = "numbers are too long:\n".toUpperCase() +
            "- use numbers from [0] to [9.9] , step [0.1]\n" +
            "- press first button to enter first number\n" +
            "- press second button to enter second number";

    private static final String WARNING_FIRST_TOO_LONG = "first number is too long:\n".toUpperCase() +
            "- use numbers from [0] to [9.9] , step [0.1]\n" +
            "- press first button to enter first number";

    private static final String WARNING_SECOND_TOO_LONG = "second number is too long:\n".toUpperCase() +
            "- use numbers from [0] to [9.9] , step [0.1]\n" +
            "- press second button to enter second number";

    public static void CheckAndCalculate(String s1, String s2, Context c) {

        context = c;

        if (s1.isEmpty() && s2.isEmpty()) {
            showToast(WARNING_BOTH_EMPTY);
        } else if (s1.isEmpty()) {
            showToast(WARNING_FIRST_EMPTY);
        } else if (s2.isEmpty()) {
            showToast(WARNING_SECOND_EMPTY);
        } else {
            if (!isStringADouble(s1) && !isStringADouble(s2)) {
                showToast(WARNING_BOTH_INCORRECT_INPUT);
            } else if (!isStringADouble(s1)) {
                showToast(WARNING_FIRST_INCORRECT_INPUT);
            } else if (!isStringADouble(s2)) {
                showToast(WARNING_SECOND_INCORRECT_INPUT);
            } else {
                if (!s1.contains("."))
                    s1 += ".0";
                if (!s2.contains("."))
                    s2 += ".0";
                if (s1.length() > 3 && s2.length() > 3) {
                    showToast(WARNING_BOTH_TOO_LONG);
                } else if (s1.length() > 3) {
                    showToast(WARNING_FIRST_TOO_LONG);
                } else if (s2.length() > 3) {
                    showToast(WARNING_SECOND_TOO_LONG);
                } else {
                    MainActivity.firstButton.setText(s1);
                    MainActivity.secondButton.setText(s2);
                    double a = Double.parseDouble(s1);
                    double b = Double.parseDouble(s2);
                }
            }
        }
    }

    private static void showToast(String warning) {
        Toast toast = Toast.makeText(context, warning, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,-500);
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

package mitso.v.homework_4;

public final class Constants {

    public static final int REQUEST_FIRST_ACTIVITY = 888;
    public static final int REQUEST_SECOND_ACTIVITY = 999;



    public static final String BUNDLE_FIRST_NUMBER = "first number";
    public static final String BUNDLE_SECOND_NUMBER = "second number";



    public static final String WARNING_FIRST_EMPTY = "there is no first number:\n".toUpperCase() +
            "- press first button to enter first number";

    public static final String WARNING_FIRST_INCORRECT_INPUT = "incorrect input - first number:\n".toUpperCase() +
            "- use only these symbols: [1234567890.]\n" +
            "- press first button to enter first number\n";

    public static final String WARNING_FIRST_TOO_LONG = "first number is too long:\n".toUpperCase() +
            "- use numbers from [0] to [9.9] , step [0.1]\n" +
            "- press first button to enter first number";



    public static final String WARNING_SECOND_EMPTY = "there is no second number:\n".toUpperCase() +
            "- press second button to enter second number";

    public static final String WARNING_SECOND_INCORRECT_INPUT = "incorrect input - second number:\n".toUpperCase() +
            "- use only these symbols: [1234567890.]\n" +
            "- press second button to enter second number\n";

    public static final String WARNING_SECOND_TOO_LONG = "second number is too long:\n".toUpperCase() +
            "- use numbers from [0] to [9.9] , step [0.1]\n" +
            "- press second button to enter second number";



    public static final String WARNING_BOTH_EMPTY = "there are no numbers:\n".toUpperCase() +
            "- press first button to enter first number\n" +
            "- press second button to enter second number";



    public static final String WARNING_SIGN_EMPTY = "there is no sign:\n".toUpperCase() +
            "- enter sign between two numbers";

    public static final String WARNING_SIGN_INCORRECT_INPUT = "incorrect input sign:\n".toUpperCase() +
            "- use one of these symbols:\n" +
            "[+] or [-] or [*] or [/]\n" +
            "- enter sign between two numbers";


}
package mitso.v.homework_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    public static Button button_first;
    public static String string_firstNumber = "";

    public static Button button_second;
    public static String string_secondNumber = "";

    public static EditText editText_sign;
    public static String string_sign = "";

    public static TextView textView_result;
    public static String string_result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemesUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.main);

        button_first = (Button) findViewById(R.id.btn_FirstButton_MA);
        button_first.setOnClickListener(this);
        button_second = (Button) findViewById(R.id.btn_SecondButton_MA);
        button_second.setOnClickListener(this);

        findViewById(R.id.btn_Calculate_MA).setOnClickListener(this);

        textView_result = (TextView) findViewById(R.id.tv_Result_MA);
        editText_sign = (EditText) findViewById(R.id.et_Sign_MA);

        findViewById(R.id.btn_LightTheme_MA).setOnClickListener(this);
        findViewById(R.id.btn_DarkTheme_MA).setOnClickListener(this);

        ThemesUtils.initViews();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_FirstButton_MA:
                openFirstActivity();
                break;
            case R.id.btn_SecondButton_MA:
                openSecondActivity();
                break;
            case R.id.btn_Calculate_MA:
                MainSupport.calculate(string_firstNumber, string_secondNumber, this);
                break;
            case R.id.btn_LightTheme_MA:
                ThemesUtils.changeToTheme(this, ThemesUtils.THEME_LIGHT);
                break;
            case R.id.btn_DarkTheme_MA:
                ThemesUtils.changeToTheme(this, ThemesUtils.THEME_DARK);
                break;
        }
    }

    private void openFirstActivity(){
        Intent intent = new Intent(this, FirstActivity.class);
        startActivityForResult(intent, Constants.REQUEST_FIRST_ACTIVITY);
    }

    private void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, Constants.REQUEST_SECOND_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case Constants.REQUEST_FIRST_ACTIVITY:
                    string_firstNumber = data.getStringExtra(Constants.BUNDLE_FIRST_NUMBER);
                    button_first.setText(string_firstNumber);
                    break;
                case Constants.REQUEST_SECOND_ACTIVITY:
                    string_secondNumber = data.getStringExtra(Constants.BUNDLE_SECOND_NUMBER);
                    button_second.setText(string_secondNumber);
                    break;
            }
        }
    }
}
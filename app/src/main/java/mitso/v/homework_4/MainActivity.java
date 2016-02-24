package mitso.v.homework_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {

    public static Button firstButton;
    public static Button secondButton;
    public static String firstNumberString = "";
    public static String secondNumberString = "";

    public static EditText signEditText;
    public static TextView resultView;
    public static String signString = "";
    public static String resultString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemesUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.main);

        firstButton = (Button) findViewById(R.id.btn_FirstButton_MA);
        firstButton.setOnClickListener(this);
        secondButton = (Button) findViewById(R.id.btn_SecondButton_MA);
        secondButton.setOnClickListener(this);

        findViewById(R.id.btn_Calculate_MA).setOnClickListener(this);

        resultView = (TextView) findViewById(R.id.tv_Result_MA);
        signEditText = (EditText) findViewById(R.id.et_Sign_MA);

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
                MainSupport.calculate(firstNumberString, secondNumberString, this);
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
                    firstNumberString = data.getStringExtra(Constants.BUNDLE_FIRST_NUMBER);
                    firstButton.setText(firstNumberString);
                    Toast toast1 = Toast.makeText(this, firstNumberString, Toast.LENGTH_SHORT);
                    toast1.setGravity(Gravity.CENTER,0,-500);
                    toast1.show();
                    break;
                case Constants.REQUEST_SECOND_ACTIVITY:
                    secondNumberString = data.getStringExtra(Constants.BUNDLE_SECOND_NUMBER);
                    secondButton.setText(secondNumberString);
                    Toast toast2 = Toast.makeText(this, secondNumberString, Toast.LENGTH_SHORT);
                    toast2.setGravity(Gravity.CENTER,0,-500);
                    toast2.show();
                    break;
            }
        }
    }
}
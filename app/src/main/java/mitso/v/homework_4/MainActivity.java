package mitso.v.homework_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends Activity implements
        CompoundButton.OnCheckedChangeListener,
        View.OnClickListener {

    private static final int REQUEST_FIRST_ACTIVITY = 888;
    private static final int REQUEST_SECOND_ACTIVITY = 999;

    private static String firstNumberString = "";
    private static String secondNumberString = "";

    public static Button firstButton;
    public static Button secondButton;

    Switch switchButton; // !!!

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.main);

        switchButton = (Switch) findViewById(R.id.sw_switchTheme_MA); // !!!
        if (switchButton != null)
            switchButton.setOnCheckedChangeListener(this);

        firstButton = (Button) findViewById(R.id.btn_FirstButton_MA);
        firstButton.setOnClickListener(this);
        secondButton = (Button) findViewById(R.id.btn_SecondButton_MA);
        secondButton.setOnClickListener(this);
        findViewById(R.id.btn_Calculate_MA).setOnClickListener(this);
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
                Support.CheckAndCalculate(firstNumberString, secondNumberString, this);
        }
    }

    private void openFirstActivity(){
        Intent intent = new Intent(this, FirstActivity.class);
        startActivityForResult(intent, REQUEST_FIRST_ACTIVITY);
    }

    private void openSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, REQUEST_SECOND_ACTIVITY);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case REQUEST_FIRST_ACTIVITY:
                    firstNumberString = data.getStringExtra(Constants.BUNDLE_FIRST_NUMBER);
                    Toast toast1 = Toast.makeText(this, firstNumberString, Toast.LENGTH_SHORT);
                    toast1.setGravity(Gravity.CENTER,0,-500);
                    toast1.show();
                    break;
                case REQUEST_SECOND_ACTIVITY:
                    secondNumberString = data.getStringExtra(Constants.BUNDLE_SECOND_NUMBER);
                    Toast toast2 = Toast.makeText(this, secondNumberString, Toast.LENGTH_SHORT);
                    toast2.setGravity(Gravity.CENTER,0,-500);
                    toast2.show();
                    break;
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) {
            Utils.changeToTheme(this, Utils.THEME_2);
        } else {
            Utils.changeToTheme(this, Utils.THEME_1);
        }
    }
}
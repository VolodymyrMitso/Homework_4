package mitso.v.homework_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends Activity implements View.OnClickListener {

    private EditText mSecondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        findViewById(R.id.btn_OK_SA).setOnClickListener(this);
        mSecondNumber = (EditText) findViewById(R.id.et_InputField_SA);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        if (SecondSupport.check(mSecondNumber, this)) {
            intent.putExtra(Constants.BUNDLE_SECOND_NUMBER, SecondSupport.returnString());
            setResult(RESULT_OK, intent);
        } else {
            setResult(RESULT_CANCELED);
        }
        finish();
    }
}

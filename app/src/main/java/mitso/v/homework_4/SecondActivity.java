package mitso.v.homework_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SecondActivity extends Activity implements View.OnClickListener {

    private EditText editText_secondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemesUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.second);

        findViewById(R.id.btn_OK_SA).setOnClickListener(this);
        editText_secondNumber = (EditText) findViewById(R.id.et_InputField_SA);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        if (SecondSupport.check(editText_secondNumber, this)) {
            intent.putExtra(Constants.BUNDLE_SECOND_NUMBER, SecondSupport.returnString());
            setResult(RESULT_OK, intent);
        } else {
            setResult(RESULT_CANCELED);
        }
        finish();
    }
}

package mitso.v.homework_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class FirstActivity extends Activity implements View.OnClickListener {

    private EditText editText_firstNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ThemesUtils.onActivityCreateSetTheme(this);
        setContentView(R.layout.first);

        findViewById(R.id.btn_OK_FA).setOnClickListener(this);
        editText_firstNumber = (EditText) findViewById(R.id.et_InputField_FA);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        if (FirstSupport.check(editText_firstNumber, this)) {
            intent.putExtra(Constants.BUNDLE_FIRST_NUMBER, FirstSupport.returnString());
            setResult(RESULT_OK, intent);
        } else {
            setResult(RESULT_CANCELED);
        }
        finish();
    }
}
package mitso.v.homework_4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class FirstActivity extends Activity implements View.OnClickListener {

    private EditText mFirstNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        findViewById(R.id.btn_OK_FA).setOnClickListener(this);
        mFirstNumber = (EditText) findViewById(R.id.et_InputField_FA);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        if (TextUtils.isEmpty(mFirstNumber.getText().toString())) {
            setResult(RESULT_CANCELED);
        } else {
            intent.putExtra(Constants.BUNDLE_FIRST_NUMBER, mFirstNumber.getText().toString());
            setResult(RESULT_OK, intent);
        }
        finish();
    }
}
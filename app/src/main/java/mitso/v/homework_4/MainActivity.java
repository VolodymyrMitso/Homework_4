package mitso.v.homework_4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Utils.onActivityCreateSetTheme(this);
        setContentView(R.layout.main);

        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.button1:
                Utils.changeToTheme(this, Utils.THEME_DEFAULT);
                break;
            case R.id.button2:
                Utils.changeToTheme(this, Utils.THEME_WHITE);
                break;
            case R.id.button3:
                Utils.changeToTheme(this, Utils.THEME_BLUE);
                break;
        }

    }
}
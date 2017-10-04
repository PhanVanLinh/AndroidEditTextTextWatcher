package toong.vn.androidedittexttextwatcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;

/**
 * https://developer.android.com/reference/android/text/TextWatcher.html
 */
public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
    EditText mEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.edittext);

        mEditText.addTextChangedListener(new TextWatcher() {
            @Override
            //This method is called to notify you that, within s, the count characters beginning at
            //start are about to be replaced by new text with length after.
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i(TAG, "_________________");
                Log.i(TAG, "beforeTextChanged: s="+s+" start="+start+" count="+count+" after="+after);
            }

            //This method is called to notify you that, within s, the count characters beginning at
            //start have just replaced old text that had length before.
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i(TAG, "onTextChanged: s="+s+" start="+start+" before="+before+" count="+count);
            }

            //This method is called to notify you that, somewhere within s, the text has been changed.
            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "afterTextChanged: s="+s);
            }
        });

        mEditText.append("1");
        mEditText.append("2");
        mEditText.append("3");
        mEditText.append("45");

        mEditText.getText().delete(1,3);
    }
}

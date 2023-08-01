package jp.suntech.c22005.kadai12;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etMailTitle;
    private EditText etAddress;
    private EditText etComment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etMailTitle = findViewById(R.id.etMailTitle);
        etAddress = findViewById(R.id.etAddress);
        etComment = findViewById(R.id.etComment);

        Button btSend = findViewById(R.id.btSend);
        Button btConfirm = findViewById(R.id.btConfirm);
        Button btClear = findViewById(R.id.btClear);

        btSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String mailTitle = etMailTitle.getText().toString();
                String address = etAddress.getText().toString();
                String comment = etComment.getText().toString();

                String message = "メール内容確認" + "\n"
                        + "名前: " + name + "\n"
                        + "メールタイトル: " + mailTitle + "\n"
                        + "メールアドレス: " + address + "\n"
                        + "質問内容: " + comment;

                //ダイアログを表示
                showSendDialog(message);
            }
        });

        btConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etName.getText().toString();
                String mailTitle = etMailTitle.getText().toString();
                String address = etAddress.getText().toString();
                String comment = etComment.getText().toString();

                String message = "メール内容確認" + "\n"
                        + "名前: " + name + "\n"
                        + "メールタイトル: " + mailTitle + "\n"
                        + "メールアドレス: " + address + "\n"
                        + "質問内容: " + comment;

                showConfirmDialog(message);
            }
        });

        btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etMailTitle.setText("");
                etAddress.setText("");
                etComment.setText("");
            }
        });
    }

    private void showSendDialog(String message) {
        SendDialogFragment dialogFragment = SendDialogFragment.newInstance(message);
        dialogFragment.show(getSupportFragmentManager(), "SendDialogFragment");
    }

    private void showConfirmDialog(String message) {
        ConfirmDialogFragment dialogFragment = ConfirmDialogFragment.newInstance(message);
        dialogFragment.show(getSupportFragmentManager(), "ConfirmDialogFragment");
    }

    public void showSnackbar(String message) {
        View rootView = findViewById(android.R.id.content);
        if (rootView != null) {
            Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show();
        }
    }
}

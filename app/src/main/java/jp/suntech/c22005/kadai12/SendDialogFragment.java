package jp.suntech.c22005.kadai12;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class SendDialogFragment extends DialogFragment {

    private static final String MESSAGE_KEY = "message";

    public static SendDialogFragment newInstance(String message) {
        SendDialogFragment fragment = new SendDialogFragment();
        Bundle args = new Bundle();
        args.putString(MESSAGE_KEY, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        String message = args.getString(MESSAGE_KEY, "");

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(message)
                .setPositiveButton("送信", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity activity = (MainActivity) getActivity();
                        if (activity != null) {
                            activity.showSnackbar("送信しました");
                        }
                    }
                })
                .setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity activity = (MainActivity) getActivity();
                        if (activity != null) {
                            activity.showSnackbar("送信をキャンセルしました");
                        }
                    }
                });

        return builder.create();
    }
}

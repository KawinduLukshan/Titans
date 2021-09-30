package com.example.sqliteexample;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

public class DiologA extends AppCompatDialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder build1 = new AlertDialog.Builder(getActivity());
        build1.setTitle("Not an Online Payment...")
                .setMessage("Appointment is already successfull.You have to visit the hospital and do your payments." +
                        "Call that Hospital to more information.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                });
        return build1.create();
    }
}

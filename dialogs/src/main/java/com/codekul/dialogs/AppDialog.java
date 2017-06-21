package com.codekul.dialogs;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * Created by aniruddha on 21/6/17.
 */

public class AppDialog extends DialogFragment {

    public static final String TAG_ALERT = "alert";
    public static final String TAG_DATE = "date";
    public static final String TAG_TIME = "time";
    public static final String TAG_PROGRESS = "progress";
    public static final String TAG_CUSTOM = "custom";

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = null;

        if(getTag().equals(TAG_ALERT)) dialog = alert();
        else if(getTag().equals(TAG_DATE)) dialog = date();
        else if(getTag().equals(TAG_TIME)) dialog = time();
        else if(getTag().equals(TAG_PROGRESS)) dialog = progress();
        else dialog = custom();

        return dialog;
    }

    private Dialog alert() {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        builder.setTitle("Title")
                .setMessage("Message")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mt("Yes");
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mt("No");
                    }
                })
                .setNeutralButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mt("Okay");
                    }
                });

        return builder.create();
    }

    private Dialog date() {
       return  new DatePickerDialog(
                getActivity(),
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        mt(""+dayOfMonth +" - "+(month+1)+" - "+year);
                    }
                },
                2017, 5, 21
        );
    }

    private Dialog time() {
        return new TimePickerDialog(
                getActivity(),
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        mt(""+hourOfDay +" : "+minute);
                    }
                },4,40,true
        );
    }

    private Dialog progress() {

        ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.setTitle(R.string.dialogTitle);
        dialog.setMessage(getResources().getString(R.string.dialogMessage));
        //dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setButton(DialogInterface.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mt("Yes clicked");
            }
        });

        return dialog;
    }

    private Dialog custom() {
        AlertDialog.Builder builder =
                new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_dialog, null, false);
        AlertDialog dialog = builder.create();
        dialog.setView(view);

        return dialog;
    }

    private void mt(String msg) {
        Toast.makeText(getActivity(), msg, Toast.LENGTH_SHORT).show();
    }
}

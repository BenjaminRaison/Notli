package ch.notli.notli.Activitys;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import java.util.Calendar;

/**
 * Created by FatzerT on 03.10.2017.
 */

public class DatePickerFragment extends DialogFragment
        implements DatePickerDialog.OnDateSetListener {

    private int year;
    private int month;
    private int day;
    private View v;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar calender = Calendar.getInstance();
        this.year = calender.get(Calendar.YEAR);
        this.month = calender.get(Calendar.MONTH);
        this.day = calender.get(Calendar.DAY_OF_MONTH);

        return new DatePickerDialog(getActivity(), this, year, month, day);
    }


    public void onDateSet(DatePicker view, int year, int month, int day) {
        this.year = year;
        this.day = day;
        this.month = month;


    }
}
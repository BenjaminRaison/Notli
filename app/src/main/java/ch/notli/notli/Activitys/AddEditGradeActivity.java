package ch.notli.notli.Activitys;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import ch.notli.notli.R;

public class AddEditGradeActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    private EditText dateText;
    private Calendar calendar = Calendar.getInstance();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_grade);
        dateText = findViewById(R.id.dateEditText);
        updateDateField();
        dateText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddEditGradeActivity.this.showDatePickerDialog(v);
            }
        });
    }


    public void showDatePickerDialog(View v) {
        new DatePickerDialog(this, this, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        calendar.clear();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, day);
        updateDateField();
    }

    public void updateDateField(){
        dateText.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
    }
}


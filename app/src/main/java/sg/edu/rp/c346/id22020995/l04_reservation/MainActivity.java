package sg.edu.rp.c346.id22020995.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //initiate variables
    EditText etName;
    EditText etMobile;
    EditText etGroupSize;
    DatePicker dp;
    TimePicker tp;
    RadioGroup rgSmoking;
    TextView tvDisplay;
    Button btnReserve;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //link variables
        etName = findViewById(R.id.editTextName);
        etMobile = findViewById(R.id.editTextMobile);
        etGroupSize = findViewById(R.id.editTextGroupSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        rgSmoking = findViewById(R.id.radioGroupSmoking);
        tvDisplay = findViewById(R.id.textViewDisplay);
        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Reserving table", Toast.LENGTH_LONG).show();
                //get string text from editText
                String name = etName.getText().toString();
                String mobile = etMobile.getText().toString();
                String groupSize = etGroupSize.getText().toString();
                //get day, month, year from datePicker
                int day = dp.getDayOfMonth();
                int month = dp.getMonth()+1;
                int year = dp.getYear();
                String date = String.format("%d / %d / %d",day,month,year);
                //get hour and minute from timePicker
                int hour = tp.getHour();
                int minute = tp.getMinute();
                String time = "";
                if (hour<10){
                    if (minute<10){
                        time = String.format("0%d:0%d",hour,minute);
                    } else {
                        time = String.format("0%d:%d",hour,minute);
                    }
                } else {
                    time = String.format("%d:%d",hour,minute);
                }
                //check radio button selection
                int checkedRadioId = rgSmoking.getCheckedRadioButtonId();
                String areaResponse = "";
                if (checkedRadioId == R.id.radioButtonNonSmoking){
                    areaResponse = "Non-Smoking Area";
                } else {
                    areaResponse = "Smoking Area";
                }
                //set final display
                String display = String.format("Name: %s \nMobile Number: %s \nGroup Size: %s \nDate: %s \nTime: %s \nArea: %s",
                        name,mobile,groupSize,date,time,areaResponse);
                tvDisplay.setText(display);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //reset editText
                etName.setText("");
                etMobile.setText("");
                etGroupSize.setText("");
                //reset date
                dp.updateDate(2020,5,1);
                //reset time
                tp.setHour(19);
                tp.setMinute(30);
                //reset radioButton and display
                rgSmoking.check(R.id.radioButtonNonSmoking);
                tvDisplay.setText("Display");
            }
        });

    }
}
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

    }
}
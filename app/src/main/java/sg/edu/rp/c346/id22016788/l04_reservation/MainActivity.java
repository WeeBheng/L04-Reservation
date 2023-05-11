package sg.edu.rp.c346.id22016788.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.TimePicker;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker DiningDate;
    TimePicker DiningTime;
    CheckBox DiningArea;
    EditText Name;
    EditText GroupSize;
    EditText MobileNumber;
    Button Reset;
    Button Confirmation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Confirmation = findViewById(R.id.ConfirmationButton);
        Reset = findViewById(R.id.ResetButton);
        MobileNumber = findViewById(R.id.MobileEdit);
        GroupSize = findViewById(R.id.GroupSizeEdit);
        Name = findViewById(R.id.NameEdit);
        DiningArea = findViewById(R.id.TableType);
        DiningTime = findViewById(R.id.TimePicker);
        DiningDate = findViewById(R.id.DatePicker);

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Name.setText("");
                MobileNumber.setText("");
                GroupSize.setText("");
                DiningArea.setChecked(false);
                DiningDate.updateDate(2020, 5, 1);
                DiningTime.setCurrentHour(19);
                DiningTime.setCurrentMinute(30);
            }
        });

        Confirmation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String FullName = Name.getText().toString();
                String GroupNum = GroupSize.getText().toString();
                String MobileNum = MobileNumber.getText().toString();
                int DiningHour = DiningTime.getCurrentHour();
                int DiningMinute = DiningTime.getCurrentMinute();
                int DiningYear = DiningDate.getYear();
                int DiningMonth = DiningDate.getMonth();
                int DiningDay = DiningDate.getDayOfMonth();
                Context NotificationContext = getApplicationContext();
                String NotificationText = "Name of reservist: " + FullName + " Mobile Number: " + MobileNum + " Group size: " + GroupNum + " Booked Date: " + DiningDay+"/"+DiningMonth +"/" +DiningYear + " Booked Time: " + DiningHour + ":" + DiningMinute + " Dining Area: ";
                int NotificationDuration = Toast.LENGTH_LONG;
                if (!DiningArea.isChecked()){
                    String stringresponse1 = "Table at non-smoking area.";
                    Toast toast = Toast.makeText(NotificationContext, NotificationText + stringresponse1, NotificationDuration);
                    toast.show();
                }
                else {
                    String stringresponse2 = "Table at smoking area.";
                    Toast toast = Toast.makeText(NotificationContext, NotificationText + stringresponse2, NotificationDuration);
                    toast.show();
                }





            }
        });



    }
}
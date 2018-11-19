package duti.com.databaseupgrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.amitshekhar.DebugDB;

import java.util.ArrayList;
import java.util.List;

import duti.com.databaseupgrade.database.DbManager;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {

    EditText studentIdEt, studentNameEt, studentAddressEt;
    Button readButton, saveButton;
    DbManager helper;
    List<Student> students = new ArrayList<Student>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get db log browser address
        Log.i("duti", "DB Browser: " + DebugDB.getAddressLog());

        helper = DbManager.getInstance(this);
        studentIdEt = (EditText)findViewById(R.id.StudentId);
        studentNameEt = (EditText)findViewById(R.id.StudentName);
        studentAddressEt = (EditText)findViewById(R.id.StudentAddress);
        readButton = (Button)findViewById(R.id.mReadButton);
        saveButton = (Button)findViewById(R.id.mSaveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = studentIdEt.getText().toString();
                String name = studentNameEt.getText().toString();
                String address = studentAddressEt.getText().toString();
                if(!TextUtils.isEmpty(id.trim()) && !TextUtils.isEmpty(name.trim()) && !TextUtils.isEmpty(address.trim())){
                    helper.insertIntoAllStudent(id, name, address);
                    studentNameEt.setText("");
                    studentIdEt.setText("");
                    studentAddressEt.setText("");
                } else Toast.makeText(MainActivity.this, "Input All Information", LENGTH_LONG);
            }
        });

        readButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                students.clear();
                students = helper.getAllStudent();
                if(students.size()>0){
                    for (Student student: students) {
                        Log.i("duti", "Record Id: " + student.getRecordId() + "\n" + "Student Id: " + student.getStudentId()  + "\n" +  "Student Name: " + student.getStudentName() + "\n" +  "Student Address: " + student.getStudentAddress());
                    }
                    Toast.makeText(MainActivity.this, "We Have Student Information", LENGTH_LONG);
                } else Toast.makeText(MainActivity.this, "No Student Information", LENGTH_LONG);
            }
        });

    }
}

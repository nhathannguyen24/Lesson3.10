package net.braniumacademy.lesson310;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textResult;
    private EditText editStaffId;
    private EditText editFullName;
    private EditText editBirthDate;
    private EditText editSalary;
    private StaffViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        addObserver();
    }

    @SuppressLint("SetTextI18n")
    private void addObserver() {
        model = new ViewModelProvider(this).get(StaffViewModel.class);
        model.getStaffs().observe(this, staffs -> {
            if (staffs.size() == 0) {
                textResult.setText("No Result");
            } else {
                StringBuilder builder = new StringBuilder();
                for (Staff staff : staffs) {
                    builder.append(staff.toString()).append("\n");
                }
                textResult.setText(builder.toString());
            }
        });
    }

    private void initViews() {
        textResult = findViewById(R.id.text_result);
        editSalary = findViewById(R.id.edit_salary);
        editFullName = findViewById(R.id.edit_fullname);
        editStaffId = findViewById(R.id.edit_staff_id);
        editBirthDate = findViewById(R.id.edit_birth_date);
        Button btnAddNew = findViewById(R.id.btn_add_new);
        btnAddNew.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String staffId = editStaffId.getText().toString().trim();
        String fullName = editFullName.getText().toString().trim();
        String salaryStr = editSalary.getText().toString().trim();
        String birthDateStr = editBirthDate.getText().toString().trim();
        long salary = 0;
        if (salaryStr.length() != 0) {
            salary = Long.parseLong(salaryStr);
        }
        model.addStaff(staffId, fullName, birthDateStr, salary);
    }
}
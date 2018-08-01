package com.example.sh.karamoziproject1.Form;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.sh.karamoziproject1.R;

public class FormActivity extends AppCompatActivity implements Interaction {
    private String strNameMassage, strFamilyMassage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        getSupportFragmentManager().beginTransaction().replace(R.id.form_fl_name, new NameFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.form_fl_family, new FamilyFragment()).commit();
        getSupportFragmentManager().beginTransaction().replace(R.id.form_fl_submit, new SubmitFragment()).commit();
    }

    @Override
    public void onSetText(String strType, String strMassage) {
        switch (strType) {
            case Tool.KEY_FRAGMENT_TYPE_NAME:
                setStrNameMassage(strMassage);
                break;
            case Tool.KEY_FRAGMENT_TYPE_FAMILY:
                setStrFamilyMassage(strMassage);
                break;
        }
    }

    @Override
    public void onClickSubmit() {
        Toast.makeText(this, getStrNameMassage() + " " + getStrFamilyMassage(), Toast.LENGTH_SHORT).show();
    }

    public String getStrNameMassage() {
        return strNameMassage;
    }

    public void setStrNameMassage(String strNameMassage) {
        this.strNameMassage = strNameMassage;
    }

    public String getStrFamilyMassage() {
        return strFamilyMassage;
    }

    public void setStrFamilyMassage(String strFamilyMassage) {
        this.strFamilyMassage = strFamilyMassage;
    }
}
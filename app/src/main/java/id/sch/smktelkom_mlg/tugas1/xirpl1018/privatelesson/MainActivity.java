package id.sch.smktelkom_mlg.tugas1.xirpl1018.privatelesson;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    EditText etNama;
    Button bOK;
    RadioGroup rgJK;
    Spinner spKelas1, spKelas2;
    TextView tvHasil, tvHasil2, tvHasil3;
    String[][] arKelas2 = {{"RPL 1", "RPL 2", "RPL 3", "RPL 4", "RPL 5", "RPL 6", "TKJ 1", "TKJ 2", "TKJ 3", "TKJ 5", "TKJ 6"},
            {"RPL 1", "RPL 2", "RPL 3", "RPL 4", "RPL 5", "RPL 6", "TKJ 1", "TKJ 2", "TKJ 3", "TKJ 5"},
            {"RPL 1", "RPL 2", "RPL 3", "RPL 4", "RPL 5", "TKJ 1", "TKJ 2", "TKJ 3", "TKJ 4"}};
    ArrayList<String> listKelas2 = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.editTextNama);
        rgJK = (RadioGroup) findViewById(R.id.radioGroupJK);
        bOK = (Button) findViewById(R.id.buttonOK);
        spKelas1 = (Spinner) findViewById(R.id.spinnerKelas1);
        spKelas2 = (Spinner) findViewById(R.id.spinnerKelas2);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);
        tvHasil2 = (TextView) findViewById(R.id.textViewHasil2);
        tvHasil3 = (TextView) findViewById(R.id.textViewHasil3);

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listKelas2);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spKelas2.setAdapter(adapter);

        spKelas1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long id) {
                listKelas2.clear();
                listKelas2.addAll(Arrays.asList(arKelas2[pos]));
                adapter.notifyDataSetChanged();
                spKelas2.setSelection(0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        findViewById(R.id.buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }
        });
    }

    private void doClick() {
        String nama = etNama.getText().toString();
        String hasil2 = null;

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
        } else if (nama.length() <= 3) {
            etNama.setError("Nama minimal 3 karakter");
        } else {
            etNama.setError(null);
        }
        tvHasil.setText("\n\nSelamat Anda telah mendaftar dengan \nNama                      : " + nama);

        if (rgJK.getCheckedRadioButtonId() != -1) {
            RadioButton rb = (RadioButton)
                    findViewById(rgJK.getCheckedRadioButtonId());
            hasil2 = rb.getText().toString();
        }
        if (hasil2 == null) {
            tvHasil2.setText("Jenis Kelamin        : -");
        } else {
            tvHasil2.setText("Jenis Kelamin        : " + hasil2);
        }

        tvHasil3.setText("Anda Kelas             : " + spKelas1.getSelectedItem().toString() + " " + spKelas2.getSelectedItem().toString());
    }
}

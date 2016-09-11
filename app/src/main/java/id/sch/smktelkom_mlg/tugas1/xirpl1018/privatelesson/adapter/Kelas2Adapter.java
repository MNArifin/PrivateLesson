package id.sch.smktelkom_mlg.tugas1.xirpl1018.privatelesson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.tugas1.xirpl1018.privatelesson.R;

/**
 * Created by MANNAR on 11/09/2016.
 */
public class Kelas2Adapter extends ArrayAdapter<String> {
    String mKelas1 = "";

    public Kelas2Adapter(Context context, ArrayList<String> listKelas2) {
        super(context, R.layout.row_spinner_kelas2, listKelas2);
    }

    public void setKelas1(String kelas1) {
        this.mKelas1 = kelas1;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        return getCustomView(position, view, parent);
    }

    @Override
    public View getDropDownView(int position, View view, ViewGroup parent) {
        return getCustomView(position, view, parent);
    }

    private View getCustomView(int position, View view, ViewGroup parent) {
        if (view == null)
            view = LayoutInflater.from(getContext())
                    .inflate(R.layout.row_spinner_kelas2, parent, false);

        TextView tvTitle = (TextView) view.findViewById(R.id.textViewTitle);
        tvTitle.setText(getItem(position).substring(0, 1));
        TextView tvKelas2 = (TextView) view.findViewById(R.id.textViewKelas2);
        tvKelas2.setText(getItem(position));
        TextView tvKelas1 = (TextView) view.findViewById(R.id.textViewKelas1);
        tvKelas1.setText(mKelas1);

        return view;
    }
}

package com.example.anon.tracnghiem;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class TracNghiemAdapter extends ArrayAdapter<ItemQuest> {
    private int layoutId;
    private ArrayList<ItemQuest> itemArray;

    public TracNghiemAdapter(Context context, int id, ArrayList<ItemQuest> itemQuestArrayList) {
        super(context, id, itemQuestArrayList);
        layoutId = id;
        itemArray = itemQuestArrayList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ItemQuest itemQuest = itemArray.get(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(layoutId,
                    parent, false);
        }

        // anh
        ImageView imageView = convertView.findViewById(R.id.anhDapAn);
        imageView.setImageResource(itemQuest.getIdImage());

        // de bai
        TextView tvDeBai = convertView.findViewById(R.id.deBai);
        tvDeBai.setText(itemQuest.getQuest());

        // cau hoi
        String[] ans = itemQuest.getAnswers();
        if (ans.length != 4) {
            Log.d("DEBUG", "Khong du 4 dap an");
            return convertView;
        }
        RadioButton radioButton_0 = convertView.findViewById(R.id.dapAn0);
        radioButton_0.setText(ans[0]);
        RadioButton radioButton_1 = convertView.findViewById(R.id.dapAn1);
        radioButton_1.setText(ans[1]);
        RadioButton radioButton_2 = convertView.findViewById(R.id.dapAn2);
        radioButton_2.setText(ans[2]);
        RadioButton radioButton_3 = convertView.findViewById(R.id.dapAn3);
        radioButton_3.setText(ans[3]);

        // check cau tra loi
        Button butCheckDapAn = convertView.findViewById(R.id.dapAnDung);
        final View finalConvertView = convertView;
        butCheckDapAn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup rgroup = finalConvertView.findViewById(R.id.nhieuDapAn);
                int chosenDapAn = rgroup.getCheckedRadioButtonId();
                if (chosenDapAn >= 0) {
                    if (chosenDapAn == itemQuest.getIdFinalDapAn()) {
                        Toast.makeText(finalConvertView.getContext(),
                                "Hey that cool answer ^_^",
                                Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(finalConvertView.getContext(),
                                "Try again :(",
                                Toast.LENGTH_SHORT).show();

                    }
                } else {
                    Toast.makeText(finalConvertView.getContext(),
                            "Check before test :)",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });

        return convertView;
    }
}

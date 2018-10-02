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
        final ViewHolderQuest viewHolderQuest;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(layoutId,
                    parent, false);
            viewHolderQuest = new ViewHolderQuest();
            viewHolderQuest.setDeBai((TextView) convertView.findViewById(R.id.deBai));
            viewHolderQuest.setAnhDapAn((ImageView) convertView.findViewById(R.id.anhDapAn));
            viewHolderQuest.setNhieuDapAn((RadioGroup) convertView.findViewById(R.id.nhieuDapAn));
            viewHolderQuest.setDapAn0((RadioButton) convertView.findViewById(R.id.dapAn0));
            viewHolderQuest.setDapAn1((RadioButton) convertView.findViewById(R.id.dapAn1));
            viewHolderQuest.setDapAn2((RadioButton) convertView.findViewById(R.id.dapAn2));
            viewHolderQuest.setDapAn3((RadioButton) convertView.findViewById(R.id.dapAn3));
            viewHolderQuest.setCheckDapAnDung((Button) convertView.findViewById(R.id
                    .checkDapAnDung));
            convertView.setTag(viewHolderQuest);
        } else {
            viewHolderQuest = (ViewHolderQuest) convertView.getTag();
        }

        // de bai
        viewHolderQuest.getDeBai().setText(itemQuest.getQuest());

        // anh
        viewHolderQuest.getAnhDapAn().setImageResource(itemQuest.getIdImage());

        // cau hoi
        String[] ans = itemQuest.getAnswers();
        if (ans.length != 4) {
            Log.d("DEBUG", "Khong du 4 dap an");
            return convertView;
        }
        viewHolderQuest.getDapAn0().setText(ans[0]);
        viewHolderQuest.getDapAn1().setText(ans[1]);
        viewHolderQuest.getDapAn2().setText(ans[2]);
        viewHolderQuest.getDapAn3().setText(ans[3]);

        // check cau tra loi
        Button butCheckDapAnDung = viewHolderQuest.getCheckDapAnDung();
        final View finalConvertView = convertView;
        butCheckDapAnDung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //RadioGroup rgroup = finalConvertView.findViewById(R.id.nhieuDapAn);
                RadioGroup radioGroup = viewHolderQuest.getNhieuDapAn();
                int chosenDapAn = radioGroup.getCheckedRadioButtonId();
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

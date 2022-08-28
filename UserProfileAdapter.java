package com.example.parkkaro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserProfileAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<com.example.parkkaro.User> ArrayList;
    public UserProfileAdapter(Context context, ArrayList<User> arrayList) {
        this.context = context;
        this.ArrayList = arrayList;

    }
    @Override
    public int getCount() {
        return ArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(context).inflate(R.layout.userprofilelist, viewGroup, false);
        TextView Username = view.findViewById(R.id.usernameretrive);
        TextView useremail = view.findViewById(R.id.useremailretrive);
        TextView userphoneno = view.findViewById(R.id.userphonenoretrive);
        TextView userpassword = view.findViewById(R.id.passworduserretrive);
        TextView usergender = view.findViewById(R.id.genderuserretrive);


        Username.setText("User Name :"+ArrayList.get(i).getUsername());
        useremail.setText("Email :"+ArrayList.get(i).getEmailaddress());
        userphoneno.setText("Phone No :"+ArrayList.get(i).getUPhoneno());
        userpassword.setText("Password :"+ArrayList.get(i).getPassword());
        usergender.setText("Gender :"+ArrayList.get(i).getGender());
        return view;
    }
}

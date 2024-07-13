package com.example.quicknews;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConnectionReceiver extends BroadcastReceiver {
//    Context mContext;

    @Override
    public void onReceive(Context context, Intent intent) {
        if(isConnected(context)){
            Toast.makeText(context,"Internet Connected",Toast.LENGTH_SHORT).show();
        }else{
            showDialog(context);
//            Toast.makeText(context,"Internet is not Connected",Toast.LENGTH_SHORT).show();
        }

    }

    public boolean isConnected(Context context){
        try{
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = cm.getActiveNetworkInfo();
            return (networkInfo != null && networkInfo.isConnected());
        }catch (NullPointerException e){
            e.printStackTrace();
            return false;
        }
    }

    public void showDialog(Context context) {

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.alert_dialog_box_network, null);
        Button btnOK = view.findViewById(R.id.btnOK);
        builder.setView(view);

        final Dialog dialog = builder.create();

        btnOK.setOnClickListener(v -> dialog.dismiss());

        dialog.show();

//        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(R.layout.alert_dialog_box_network,null);
//        Button btnOK = view.findViewById(R.id.btnOK);
//        builder.setView(view);
//
//        final Dialog dialog = builder.create();
//
//        btnOK.setOnClickListener(v -> dialog.dismiss());
//
//        dialog.show();
    }
}

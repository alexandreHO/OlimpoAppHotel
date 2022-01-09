package br.unip.olimpo;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.text.DateFormat;
import java.util.Calendar;

public class RoomFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_room, container, false);

        // Vai para Icaro Booking
        Button btnIcaroBooking = (Button) view.findViewById(R.id.button3);

        btnIcaroBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new IcaroBooking());
                fragmentTransaction.commit();
            }
        });


        // Vai para Apolo Booking
        Button btnApoloBooking = (Button) view.findViewById(R.id.button4);

        btnApoloBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new ApoloBooking());
                fragmentTransaction.commit();
            }
        });


        // Vai para Zeus Booking
        Button btnZeusBooking = (Button) view.findViewById(R.id.button5);

        btnZeusBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new ZeusBooking());
                fragmentTransaction.commit();
            }
        });

        return  view;
    }

}
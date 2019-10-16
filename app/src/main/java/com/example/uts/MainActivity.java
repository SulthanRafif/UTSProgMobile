package com.example.uts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.example.uts.fragments.Menu;
import com.example.uts.fragments.ResultSiswa;
import com.example.uts.fragments.Siswa;

import android.content.DialogInterface;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity implements Menu.OnFragmentInteractionListener, Siswa.OnFragmentInteractionListener, ResultSiswa.OnFragmentInteractionListener {

    private ResultSiswa resultSiswa;
    private Siswa siswa;
    private Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = new Menu();
        siswa = new Siswa();
        resultSiswa = new ResultSiswa();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, menu)
                .commit();

    }


    @Override
    public void onSiswaButtonClicked() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, siswa)
                .commit();
    }

    @Override
    public void onSubmitSiswa(String nis, String nama, String alamat, String handphone, String keterangan) {
//        resultSiswa.setInformation(String.format("NIS anda", nis));
//        resultSiswa.setInformation(String.format("Nama anda", nama));
//        resultSiswa.setInformation(String.format("Alamat anda", alamat));
//        resultSiswa.setInformation(String.format("No Handphone anda", handphone));
//
//        resultSiswa.setInformation(String.format("Keterangan anda " + keterangan));
//
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, resultSiswa)
//                .commit();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

        alertDialogBuilder.setTitle("Profil Siswa");

        alertDialogBuilder.setMessage(" Nis : "+nis+"\n Nama : "+nama+"\n Alamat : "+alamat+"\n Handphone : "+handphone+"\n Keterangan : "+keterangan).setIcon(R.mipmap.ic_launcher).setCancelable(false).setPositiveButton("Close", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }

    @Override
    public void onBackToMenuClicked(String tag) {

    }
}

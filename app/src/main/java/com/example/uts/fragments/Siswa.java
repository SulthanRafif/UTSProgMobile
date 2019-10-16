package com.example.uts.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.uts.R;
import com.example.uts.util.SiswaData;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Siswa.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Siswa extends Fragment {

    private OnFragmentInteractionListener mListener;

    public Siswa() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_siswa, container, false);

        final EditText nisText = view.findViewById(R.id.inputNIS);
        final EditText namaText = view.findViewById(R.id.inputNama);
        final EditText alamatText = view.findViewById(R.id.inputAlamat);
        final EditText handphoneText = view.findViewById(R.id.inputHandphone);
        final EditText keteranganText = view.findViewById(R.id.inputKeterangan);

        Button submitButton = view.findViewById(R.id.SubmitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mListener != null){
                    String nisString = nisText.getText().toString();
                    String namaString = namaText.getText().toString();
                    String alamatString = alamatText.getText().toString();
                    String handphoneString = handphoneText.getText().toString();
                    String keteranganString = keteranganText.getText().toString();

                    if(!TextUtils.isEmpty(nisString) && !TextUtils.isEmpty(namaString) && !TextUtils.isEmpty(alamatString) && !TextUtils.isEmpty(handphoneString) && !TextUtils.isEmpty(keteranganString)){
                        String nis = nisString;
                        String nama = namaString;
                        String alamat = alamatString;
                        String handphone = handphoneString;
                        String keterangan = keteranganString;

                        SiswaData siswaData = new SiswaData(nis, nama, alamat, handphone, keterangan);
                        mListener.onSubmitSiswa(siswaData.getNIS(), siswaData.getNama(), siswaData.getAlamat(), siswaData.getHandphone(), siswaData.getKeterangan());

                    }

                    else{
                        Toast.makeText(getActivity(), "Lengkapi data diri anda", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });

        return view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onSubmitSiswa(String nis, String nama, String alamat, String handphone, String keterangan);
    }
}

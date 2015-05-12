package hoshikoo.c4q.nyc.horoscope1;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ChooseSign.ChooseSignFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ChooseSign#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChooseSign extends Fragment {

    private ChooseSignFragmentInteractionListener mListener;
    private static ChooseSign fragment = null;

    public static ChooseSign newInstance() {
        if (fragment == null) {
            fragment = new ChooseSign();
        }
        return fragment;
    }

    public ChooseSign() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_choose_sign, container, false);

        setupZodiacSignListeners(view);

        return view;
    }

    private void setupZodiacSignListeners(View view) {
        Button ariesButton = (Button) view.findViewById(R.id.button_Aries);
        ariesButton.setOnClickListener(signSelectButtonListner);

        Button tauruButton = (Button) view.findViewById(R.id.button_Taurus);
        tauruButton.setOnClickListener(signSelectButtonListner);

        Button geminiButton = (Button) view.findViewById(R.id.button_Gemini);
        geminiButton.setOnClickListener(signSelectButtonListner);

    }

    private View.OnClickListener signSelectButtonListner = (new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String sign = "aries";

            if (mListener != null) {
                mListener.onSignChosen(sign);
            }
        }
    });

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (ChooseSignFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
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
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface ChooseSignFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onSignChosen(String sign);
    }

}

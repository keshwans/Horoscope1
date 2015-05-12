package hoshikoo.c4q.nyc.horoscope1;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by keshwans on 5/11/15.
 */
public class CompatibilityFragment extends Fragment {

    public interface CompatibilityFragmentListener {
        void onCompatiblityDone();
    }

    private static CompatibilityFragment instance = null;
    private CompatibilityFragmentListener mListener = null;

    public static CompatibilityFragment getInstance() {
        if (instance == null) {
            instance = new CompatibilityFragment();
        }

        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.compatibility_fragment, container, false);
        configureListeners(view);
        return view;

    }

    private void configureListeners(View view) {
        TextView tv = (TextView) view.findViewById(R.id.matched_msg);
        tv.setText("NO chance");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mListener = (CompatibilityFragmentListener) activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}

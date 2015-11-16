package aykutenesguvencan.muh_bil_uyg;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.text.NumberFormat;

/**
 * Created by Aykutt on 7.11.2015.
 */
public class Sekil9Dialog extends DialogFragment {
    EditText a;
    EditText ai;
    EditText b;
    EditText bi;
    EditText T;
    EditText j;
    EditText St;
    Button coz;

    public static Sekil2Dialog newInstance() {
        Sekil2Dialog dialog = new Sekil2Dialog();
        dialog.setStyle(DialogFragment.STYLE_NORMAL, R.style.AppTheme);

        return dialog;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getDialog() != null) {
            getDialog().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getDialog().getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sekil9_sayfa, container, false);

        a = (EditText) v.findViewById(R.id.editText43);
        ai = (EditText) v.findViewById(R.id.editText44);
        b = (EditText) v.findViewById(R.id.editText33);
        bi = (EditText) v.findViewById(R.id.editText39);
        T = (EditText) v.findViewById(R.id.editText40);
        j = (EditText) v.findViewById(R.id.editText41);
        St = (EditText) v.findViewById(R.id.editText42);
        coz = (Button) v.findViewById(R.id.button9);

        coz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a1 = Double.valueOf(String.valueOf(a.getText()));
                double ai1 = Double.valueOf(String.valueOf(ai.getText()));
                double b1 = Double.valueOf(String.valueOf(b.getText()));
                double bi1 = Double.valueOf(String.valueOf(bi.getText()));
                double T1 = Double.valueOf(String.valueOf(T.getText()));

                double q = ai1/a1;

                double j1 = ((Math.PI*Math.pow(a1,3)*Math.pow(b1,3))/(Math.pow(a1,2)+Math.pow(b1,2))*(1-Math.pow(q,4)));
                double St1 = (2*T1)/(Math.PI*a1*Math.pow(b1,2)*(1-Math.pow(q,4)));

                NumberFormat nf = NumberFormat.getInstance();
                nf.setMaximumFractionDigits(4);
                String S = nf.format(j1);
                String S2 = nf.format(St1);

                j.setText(String.valueOf(S));
                St.setText(String.valueOf(S2));
            }
        });


        return v;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);

        return dialog;
    }
}

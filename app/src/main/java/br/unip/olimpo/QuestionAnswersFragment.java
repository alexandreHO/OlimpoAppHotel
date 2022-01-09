package br.unip.olimpo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuestionAnswersFragment extends Fragment {

    TextView txtQ1, txtQ2, txtQ3, txtA1, txtA2, txtA3;
    ImageView imgViewQ1, imgViewQ2, imgViewQ3;
    View vwQ1, vwQ2, vwQ3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_answers, container, false);

        // Hide && show (Answer 1)
        txtQ1 = view.findViewById(R.id.textView47);
        txtA1 = view.findViewById(R.id.txtAnswerA);
        imgViewQ1 = view.findViewById(R.id.arrowImgViewA);
        vwQ1 = view.findViewById(R.id.answerVwA);

        txtQ1.setOnClickListener(view1 -> {
            txtA1.setVisibility(View.VISIBLE);
            vwQ1.setVisibility(View.VISIBLE);

            imgViewQ1.setRotation(180);
            if (txtA1.getVisibility() == View.VISIBLE && vwQ1.getVisibility() == View.VISIBLE){
                txtA1.setVisibility(View.GONE);
                vwQ1.setVisibility(View.GONE);

                imgViewQ1.setRotation(0);

            }

        });

        imgViewQ1.setOnClickListener(view1 -> {
            txtA1.setVisibility(View.VISIBLE);
            vwQ1.setVisibility(View.VISIBLE);

            imgViewQ1.setRotation(180);

        });

        // Hide && show (Answer 2)
        txtQ2 = view.findViewById(R.id.textView48);
        txtA2 = view.findViewById(R.id.txtAnswerB);
        imgViewQ2 = view.findViewById(R.id.arrowImgViewB);
        vwQ2 = view.findViewById(R.id.answerVwB);

        txtQ2.setOnClickListener(view1 -> {
            txtA2.setVisibility(View.VISIBLE);
            vwQ2.setVisibility(View.VISIBLE);

            imgViewQ2.setRotation(180);
            if (txtA2.getVisibility() == View.VISIBLE && vwQ2.getVisibility() == View.VISIBLE){
                txtA2.setVisibility(View.GONE);
                vwQ2.setVisibility(View.GONE);

                imgViewQ2.setRotation(0);

            }

        });

        imgViewQ2.setOnClickListener(view1 -> {
            txtA2.setVisibility(View.VISIBLE);
            vwQ2.setVisibility(View.VISIBLE);

            imgViewQ2.setRotation(180);
        });

        // Hide && show (Answer 3)
        txtQ3 = view.findViewById(R.id.textView49);
        txtA3 = view.findViewById(R.id.txtAnswerC);
        imgViewQ3 = view.findViewById(R.id.arrowImgViewC);
        vwQ3 = view.findViewById(R.id.answerVwC);

        txtQ3.setOnClickListener(view1 -> {
            txtA3.setVisibility(View.VISIBLE);
            vwQ3.setVisibility(View.VISIBLE);

            imgViewQ3.setRotation(180);
            if (txtA3.getVisibility() == View.VISIBLE && vwQ3.getVisibility() == View.VISIBLE){
                txtA3.setVisibility(View.GONE);
                vwQ3.setVisibility(View.GONE);

                imgViewQ3.setRotation(0);

            }

        });

        imgViewQ3.setOnClickListener(view1 -> {
            txtA3.setVisibility(View.VISIBLE);
            vwQ3.setVisibility(View.VISIBLE);

            imgViewQ3.setRotation(180);
        });

        return view;
    }
}

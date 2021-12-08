package com.ipn.estructuradedatos;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

public class Quiz {

    public static List<Questions> initQuiz(Context context)
    {
        List<Answers> answers1 = new ArrayList<>();
        answers1.add(new Answers(context.getString(R.string.progresoAnswer1), true));
        answers1.add(new Answers(context.getString(R.string.progresoAnswer2), false));
        answers1.add(new Answers(context.getString(R.string.progresoAnswer3), false));
        answers1.add(new Answers(context.getString(R.string.progresoAnswer4), false));

        List<Answers> answers2 = new ArrayList<>();
        answers2.add(new Answers(context.getString(R.string.sisalAnswer1), true));
        answers2.add(new Answers(context.getString(R.string.sisalAnswer2), false));
        answers2.add(new Answers(context.getString(R.string.sisalAnswer3), false));
        answers2.add(new Answers(context.getString(R.string.sisalAnswer4), false));

        List<Answers> answers3 = new ArrayList<>();
        answers3.add(new Answers(context.getString(R.string.chelemAnswer1), true));
        answers3.add(new Answers(context.getString(R.string.chelemAnswer2), false));
        answers3.add(new Answers(context.getString(R.string.chelemAnswer3), false));
        answers3.add(new Answers(context.getString(R.string.chelemAnswer4), false));

        List<Answers> answers4 = new ArrayList<>();
        answers4.add(new Answers(context.getString(R.string.cenoteIkKilAnswer1), true));
        answers4.add(new Answers(context.getString(R.string.cenoteIkKilAnswer2), false));
        answers4.add(new Answers(context.getString(R.string.cenoteIkKilAnswer3), false));
        answers4.add(new Answers(context.getString(R.string.cenoteIkKilAnswer4), false));

        List<Answers> answers5 = new ArrayList<>();
        answers5.add(new Answers(context.getString(R.string.cenoteXlacahAnswer1), true));
        answers5.add(new Answers(context.getString(R.string.cenoteXlacahAnswer2), false));
        answers5.add(new Answers(context.getString(R.string.cenoteXlacahAnswer3), false));
        answers5.add(new Answers(context.getString(R.string.cenoteXlacahAnswer4), false));

        List<Answers> answers6 = new ArrayList<>();
        answers6.add(new Answers(context.getString(R.string.chichenItzaAnswer1), true));
        answers6.add(new Answers(context.getString(R.string.chichenItzaAnswer2), false));
        answers6.add(new Answers(context.getString(R.string.chichenItzaAnswer3), false));
        answers6.add(new Answers(context.getString(R.string.chichenItzaAnswer4), false));

        List<Answers> answers7 = new ArrayList<>();
        answers7.add(new Answers(context.getString(R.string.EkBalamAnswer1), true));
        answers7.add(new Answers(context.getString(R.string.EkBalamAnswer2), false));
        answers7.add(new Answers(context.getString(R.string.EkBalamAnswer3), false));
        answers7.add(new Answers(context.getString(R.string.EkBalamAnswer4), false));

        List<Answers> answers8 = new ArrayList<>();
        answers8.add(new Answers(context.getString(R.string.uxmalAnswer1), true));
        answers8.add(new Answers(context.getString(R.string.uxmalAnswer2), false));
        answers8.add(new Answers(context.getString(R.string.uxmalAnswer3), false));
        answers8.add(new Answers(context.getString(R.string.uxmalAnswer4), false));

        List<Answers> answers9 = new ArrayList<>();
        answers9.add(new Answers(context.getString(R.string.coloradasAnswer1), true));
        answers9.add(new Answers(context.getString(R.string.coloradasAnswer2), false));
        answers9.add(new Answers(context.getString(R.string.coloradasAnswer3), false));
        answers9.add(new Answers(context.getString(R.string.coloradasAnswer4), false));

        List<Answers> answers10 = new ArrayList<>();
        answers10.add(new Answers(context.getString(R.string.CelestunAnswer1), true));
        answers10.add(new Answers(context.getString(R.string.CelestunAnswer2), false));
        answers10.add(new Answers(context.getString(R.string.CelestunAnswer3), false));
        answers10.add(new Answers(context.getString(R.string.CelestunAnswer4), false));

        List<Questions> quizList = new ArrayList<>();
        quizList.add(new Questions(1, context.getString(R.string.progresoQuestion), answers1, R.drawable.puerto_progreso_yucatan));
        quizList.add(new Questions(2, context.getString(R.string.sisalQuestion), answers2, R.drawable.sisal));
        quizList.add(new Questions(3, context.getString(R.string.chelemQuestion), answers3, R.drawable.chelem));
        quizList.add(new Questions(4, context.getString(R.string.cenoteIkKilQuestion), answers4, R.drawable.cenote_sagrado_ik_kil));
        quizList.add(new Questions(5, context.getString(R.string.cenoteXlacahQuestion), answers5, R.drawable.cenote_xlacah));
        quizList.add(new Questions(6, context.getString(R.string.chichenItzaQuestion), answers6, R.drawable.chichenitza));
        quizList.add(new Questions(7, context.getString(R.string.EkBalamQuestion), answers7, R.drawable.ekbalam));
        quizList.add(new Questions(8, context.getString(R.string.uxmalQuestion), answers8, R.drawable.uxmal));
        quizList.add(new Questions(9, context.getString(R.string.coloradasQuestion), answers9, R.drawable.lascoloradas));
        quizList.add(new Questions(10, context.getString(R.string.CelestunQuestion), answers10, R.drawable.celestun));
        return quizList;
    }
}

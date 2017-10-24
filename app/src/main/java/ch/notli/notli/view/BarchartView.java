package ch.notli.notli.view;

import android.content.Context;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

import ch.notli.notli.db.INotliDatabase;
import ch.notli.notli.db.MockNotliDatabaseHelper;
import ch.notli.notli.db.model.Grade;
import ch.notli.notli.db.model.Semester;
import ch.notli.notli.db.model.Subject;

public class BarchartView extends View {
    private INotliDatabase db;
    private Context context;
    private Semester semester;

    public BarchartView(Context context, Semester semester) {
        super(context);
        db = new MockNotliDatabaseHelper();
        this.context = context;
        this.semester = semester;
        init();
    }

    private void init() {

    }

    private void createChart(BarChart chart) {
        BarData data = new BarData(getXLabels(), getDataset());
        chart.setData(data);
    }

    private BarDataSet getDataset() {
        return new BarDataSet(getEntries(), "er");
    }

    private ArrayList<String> getXLabels() {
        ArrayList<String> labels = new ArrayList<>();
        List<Subject> subjectList = db.getSubjects(semester);
        for(Subject subject : subjectList) {
            labels.add(subject.getName());
        }
        return labels;
    }

    private ArrayList<BarEntry> getEntries() {
        ArrayList<BarEntry> entries = new ArrayList<>();
        List<Grade> gradeList = db.getGrades(semester);     //TODO: Durchschnitt
        for(int index = 0; index <= gradeList.size(); index++) {
            entries.add(new BarEntry((float) gradeList.get(index).getGrade(), index));
        }
        return entries;
    }
}

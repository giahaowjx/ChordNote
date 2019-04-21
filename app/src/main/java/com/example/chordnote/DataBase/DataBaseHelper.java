package com.example.chordnote.DataBase;

import java.io.BufferedReader;
import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import android.support.v7.app.AppCompatActivity;


import com.example.chordnote.activity.R;

import org.litepal.crud.DataSupport;

public class DataBaseHelper extends AppCompatActivity {
    public   void LoadInitialData(Context context) {

        LoadPracticeData(context);
        LoadLessonData(context);

    }
    //加载初始数据
    public void LoadPracticeData(Context context){
        BufferedReader readerForPractice = null;
        try {

            //初始加载练习相关信息到数据库中
            //建立textforpractice的读取器
            InputStream in = context.getResources().openRawResource(R.raw.textforpractice);
            readerForPractice=new BufferedReader(new InputStreamReader(in));
            String strlineForPractice="";
            strlineForPractice=readerForPractice.readLine();//跳过textforpractice文件的第一行
            while ((strlineForPractice=readerForPractice.readLine())!=null){
                String[] values=strlineForPractice.split(";");//根据分号分割text文件里的文本再分别存在对应表格中
                Practice_Table practice=new Practice_Table();
                practice.setID(Integer.valueOf(values[0]));
                practice.setCompleted(Boolean.valueOf(values[1]));
                practice.setCollected(Boolean.valueOf(values[2]));
                practice.setCorrectOrNot(Boolean.valueOf(values[3]));
                practice.setNotes(values[4]);
                practice.setCorrectAnswer(values[5].toCharArray()[0]);
                practice.setProblem(values[6]);
                String[]options=values[7].split("、");
                List<String> Options= Arrays.asList(options);
                practice.setOptions(Options);
                practice.saveIfNotExist();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (readerForPractice != null) {
                try {
                    readerForPractice.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void LoadLessonData(Context context){
        BufferedReader readerForLesson = null;
        try {

            //初始加载练习相关信息到数据库中
            //建立textforlesson的读取器
            InputStream in = context.getResources().openRawResource(R.raw.textforlesson);
            readerForLesson=new BufferedReader(new InputStreamReader(in));
            String strlineForLesson="";
            strlineForLesson=readerForLesson.readLine();//跳过textforlesson文件的第一行

            while ((strlineForLesson=readerForLesson.readLine())!=null){
                Lesson_Table lesson=new Lesson_Table();
                String[] values=strlineForLesson.split(";");//根据分号分割text文件里的文本再分别存在对应表格中
                lesson.setId(Integer.valueOf(values[0]));
                lesson.setClassChapter(values[1]);
                lesson.setClassSection(values[2]);
                lesson.setLessonName(values[3]);
                lesson.setClassIntroduction(values[4]);

                //给课程添加对应的多个练习
                List<Practice_Table>lists=new ArrayList<>();
                String[]practiceIDs=values[5].split(",");
                for(int i=0;i<practiceIDs.length;i++){
                    Practice_Table practice=DataSupport.where("id=?",practiceIDs[i]).limit(1).findFirst(Practice_Table.class);
                    lists.add(practice);
                }
                lesson.setThisSectionProblems(lists);
                lesson.saveIfNotExist();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (readerForLesson != null) {
                try {
                    readerForLesson.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //从数据库提取信息
    //从练习表里提取
    public char getAnswerFromDB(int id){
        Practice_Table practice=DataSupport.where("id=?",String.valueOf(id))
                                            .findFirst(Practice_Table.class);
        return practice.getCorrectAnswer();
    }
    public String getProFromDB(int id){
        Practice_Table practice=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Practice_Table.class);
        return practice.getProblem();
    }
    public List<String> getOptionsFromDB(int id){
        Practice_Table practice=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Practice_Table.class);
        return practice.getOptions();
    }
    public boolean getCompleteFromDB(int id){
        Practice_Table practice=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Practice_Table.class);
        return practice.isCompleted();
    }
    public boolean getCollectedFromDB(int id){
        Practice_Table practice=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Practice_Table.class);
        return practice.isCollected();
    }
    public boolean getCorrectOrNotFromDB(int id){
        Practice_Table practice=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Practice_Table.class);
        return practice.isCorrectOrNot();
    }
    public String getNoteFromDB(int id){
        Practice_Table practice=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Practice_Table.class);
        return practice.getNotes();
    }
    public Lesson_Table getLessonFromDB(int id){
        Practice_Table practice=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Practice_Table.class);
        return practice.getLesson();
    }
    //从课程表里提取
    public String getclassChapterFromDB(int id){
        Lesson_Table lesson=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Lesson_Table.class);
        return  lesson.getClassChapter();
    }
    public String getclassSectionFromDB(int id){
        Lesson_Table lesson=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Lesson_Table.class);
        return  lesson.getClassSection();
    }
    public String getclassNameFromDB(int id){
        Lesson_Table lesson=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Lesson_Table.class);
        return  lesson.getLessonName();
    }
    public String getInfoFromDB(int id){
        Lesson_Table lesson=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Lesson_Table.class);
        return  lesson.getClassIntroduction();
    }
    public List getproblemIDsfromDB(int id){
        Lesson_Table lesson=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Lesson_Table.class);
        List<Practice_Table>practices=lesson.getThisSectionProblems();
        List practiceIDs=new ArrayList();
        for(Practice_Table practice:practices){
            practiceIDs.add(practice.getID());
        }
       return practiceIDs;
    }

    //写入数据库
    //写入练习表
    public void setDBcollectOrNOt(boolean collected,int id){
        Practice_Table practice=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Practice_Table.class);
        practice.setCollected(collected);
        practice.save();
    }
    public void setDBcorrectOrNOt(boolean corrected,int id){
        Practice_Table practice=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Practice_Table.class);
        practice.setCorrectOrNot(corrected);
        practice.save();
    }
    public void setDBcompleteOrNOt(boolean completed,int id){
        Practice_Table practice=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Practice_Table.class);
        practice.setCompleted(completed);
        practice.save();
    }
    public void setDBNote(String note,int id){
        Practice_Table practice=DataSupport.where("id=?",String.valueOf(id))
                .findFirst(Practice_Table.class);
        practice.setNotes(note);
        practice.save();
    }






}

package com.example.imoocmusicdemo.utils;

import android.widget.Toast;

import com.example.imoocmusicdemo.MyApplication;
import com.example.imoocmusicdemo.entities.Book;
import com.example.imoocmusicdemo.entities.Exam;
import com.example.imoocmusicdemo.entities.HomeWork;
import com.example.imoocmusicdemo.entities.Result;
import com.example.imoocmusicdemo.entities.Speclass;
import com.example.imoocmusicdemo.entities.Student;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Response;

public class JsonParser {


    /**
     * 验证用户登录，获取student对象
     * @param json
     * @return
     * @throws JSONException
     */
    public Student userValidate(String json) throws JSONException {


        Result result = new Result();
        Student student = new Student();
        JSONObject jsonObject = new JSONObject(json);


        result.setCode(Integer.parseInt(jsonObject.getString("code")));
        result.setMsg(jsonObject.getString("msg"));
        result.setData(jsonObject.getString("data"));

        JSONObject jsonObject1 = new JSONObject(result.getData());
        student.setStudentId(Integer.parseInt(jsonObject1.getString("studentId")));
        student.setStudentName(jsonObject1.getString("studentName"));
        student.setStudentPassword(jsonObject1.getString("studentPassword"));
        student.setStudentIcon(jsonObject1.getString("studentIcon"));
        student.setMajorId(Integer.parseInt(jsonObject1.getString("majorId")));

        if (result.getCode() == 0)
            return student;
        else {
            return null;
        }
    }

    /**
     * 将json转化为book对象的list
     * @param json
     * @return
     * @throws JSONException
     */
    public List<Book> json2book(String json) throws JSONException {
        Result result = new Result();
        JSONObject jsonObject = new JSONObject(json);
        List<Book> list;
        list = new ArrayList<>();

        result.setCode(Integer.parseInt(jsonObject.getString("code")));
        result.setMsg(jsonObject.getString("msg"));
        result.setData(jsonObject.getString("data"));

        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);

            Book book = new Book();

            book.setBookId(jsonObject1.getInt("bookId"));
            book.setBookName(jsonObject1.getString("bookName"));
            book.setBookIcon(jsonObject1.getString("bookIcon"));
            book.setBookInfo(jsonObject1.getString("bookInfo"));

            list.add(book);
        }

        return list;
    }


    /**
     * 将json转化为exam对象的list
     * @param json
     * @return
     * @throws JSONException
     */
    public List<Exam> json2exam(String json) throws JSONException {
        Result result = new Result();
        JSONObject jsonObject = new JSONObject(json);
        List<Exam> list;
        list = new ArrayList<>();

        result.setCode(Integer.parseInt(jsonObject.getString("code")));
        result.setMsg(jsonObject.getString("msg"));
        result.setData(jsonObject.getString("data"));

        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);

            Exam exam = new Exam();

            exam.setExamId(jsonObject1.getInt("examId"));
            exam.setExamName(jsonObject1.getString("examName"));
            exam.setExamTime(jsonObject1.getString("examTime"));
            exam.setExamInfo(jsonObject1.getString("examInfo"));

            list.add(exam);
        }

        return list;
    }


    public List<Speclass> json2speclass(String json) throws JSONException {
        Result result = new Result();
        JSONObject jsonObject = new JSONObject(json);
        List<Speclass> list;
        list = new ArrayList<>();

        result.setCode(Integer.parseInt(jsonObject.getString("code")));
        result.setMsg(jsonObject.getString("msg"));
        result.setData(jsonObject.getString("data"));

        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);

            Speclass speclass = new Speclass();

            speclass.setSpeclassId(jsonObject1.getInt("speclassId"));
            speclass.setSpeclassName(jsonObject1.getString("speclassName"));
            speclass.setSpeclassTime(jsonObject1.getInt("speclassTime"));
            speclass.setSpeclassLoc(jsonObject1.getString("speclassLoc"));
            speclass.setTeacherId(jsonObject1.getInt("teacherId"));

            list.add(speclass);
        }

        return list;
    }


    public List<HomeWork> json2homework(String json) throws JSONException {
        Result result = new Result();
        JSONObject jsonObject = new JSONObject(json);
        List<HomeWork> list;
        list = new ArrayList<>();

        result.setCode(Integer.parseInt(jsonObject.getString("code")));
        result.setMsg(jsonObject.getString("msg"));
        result.setData(jsonObject.getString("data"));

        JSONArray jsonArray = jsonObject.getJSONArray("data");
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject1 = (JSONObject) jsonArray.get(i);

            HomeWork homework = new HomeWork();

            homework.setHomeworkId(jsonObject1.getInt("homeworkId"));
            homework.setHomeworkInfo(jsonObject1.getString("homeworkInfo"));
            homework.setHomeworkTime(jsonObject1.getString("homeworkTime"));

            list.add(homework);
        }

        return list;
    }

    public String json2tName(String json) throws JSONException {
        Result result = new Result();
        JSONObject jsonObject = new JSONObject(json);

        result.setCode(Integer.parseInt(jsonObject.getString("code")));
        result.setMsg(jsonObject.getString("msg"));
        result.setData(jsonObject.getString("data"));

        return result.getData();
    }
}

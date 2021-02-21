package com.example.imoocmusicdemo.utils;

import com.zhy.http.okhttp.OkHttpUtils;
import java.io.IOException;

import okhttp3.Response;


public class HttpExecutor {

    private static String mBaseUrl = "http://192.168.1.102:8080/ejnu/";
    private static Thread thread = null;
    private static String result; //从服务器取回的值

    private static String studentId, studentPassword;
    private static String speclassId, teacherId;

    public String doLogin(String si, String sp) throws InterruptedException {
        studentId = si;
        studentPassword = sp;


        thread = initThread();
        thread.start();
        thread.join();
        return result;
    }

    public String doGetBook() throws InterruptedException {

        thread = initThreadGetBook();
        thread.start();
        thread.join();
        return result;
    }

    public String doGetExam() throws InterruptedException {

        thread = initThreadGetExam();
        thread.start();
        thread.join();
        return result;
    }

    public String doPostSpeclass() throws InterruptedException {

        thread = initThreadPostSpeclass();
        thread.start();
        thread.join();
        return result;
    }


    public String doPostHomework(String speId) throws InterruptedException {

        speclassId = speId;

        thread = initThreadPostHomework();
        thread.start();
        thread.join();
        return result;
    }

    public String doPostTeacher(String teaId) throws InterruptedException {

        teacherId = teaId;

        thread = initThreadPostTeacher();
        thread.start();
        thread.join();
        return result;
    }

    private static Thread initThread()
    {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response
                     = OkHttpUtils
                            .post()
                            .url(mBaseUrl+ "user/student/login")
                            .addParams("studentId", studentId)
                            .addParams("studentPassword",studentPassword)
                            .build()
                            .execute();
                    result = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static Thread initThreadGetBook()
    {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response
                            = OkHttpUtils
                            .get()
                            .url(mBaseUrl+ "user/data/book/list")
                            .build()
                            .execute();
                    result = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static Thread initThreadGetExam()
    {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response
                            = OkHttpUtils
                            .get()
                            .url(mBaseUrl+ "user/data/exam/list")
                            .build()
                            .execute();
                    result = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    private static Thread initThreadPostSpeclass()
    {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response
                            = OkHttpUtils
                            .post()
                            .url(mBaseUrl+ "user/student/speclass")
                            .addParams("studentId", studentId)
                            .build()
                            .execute();
                    result = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static Thread initThreadPostHomework()
    {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response
                            = OkHttpUtils
                            .post()
                            .url(mBaseUrl+ "user/student/homework")
                            .addParams("speclassId", speclassId)
                            .build()
                            .execute();
                    result = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private static Thread initThreadPostTeacher()
    {
        return new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response
                            = OkHttpUtils
                            .post()
                            .url(mBaseUrl+ "user/student/speclass/teacher")
                            .addParams("teacherId", teacherId)
                            .build()
                            .execute();
                    result = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

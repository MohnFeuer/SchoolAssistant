package com.example.imoocmusicdemo.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.imoocmusicdemo.R;
import com.example.imoocmusicdemo.activities.LoginActivity;
import com.example.imoocmusicdemo.entities.Student;

import org.json.JSONException;


public class UserUtils {


    /**
     * 验证登录用户输入合法性
     */
    @SuppressLint("ShowToast")
    public static Student validateLogin (Context context, String phone, String password) throws JSONException, InterruptedException {
        //简单
//        RegexUtils.isMobileSimple(phone);
        //精确
        /*
        if( ! RegexUtils.isMobileExact(phone)) {
            Toast.makeText(context, "无效手机号", Toast.LENGTH_SHORT);
            return false;
        }
        */

        if( TextUtils.isEmpty(password)) {
            Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
            return null;
        }

        HttpExecutor httpExecutor = new HttpExecutor();
        JsonParser jsonParser = new JsonParser();
        String result = httpExecutor.doLogin(phone,password);
        if(result == null)
        {
            Toast.makeText(context, "json返回为空", Toast.LENGTH_SHORT).show();
            return null;
        }


        Student student = jsonParser.userValidate(result);
        if(student == null)
        {
            Toast.makeText(context, "用户名不存在或密码错误", Toast.LENGTH_SHORT).show();
            return null;
        }

        return student;
    }


    /**
     * 退出登录
     * @param context
     */
    public static void logout (Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        //添加intent 标识符，清理task栈，并且新生成一个task栈
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        //定义activity跳转动画
        ((Activity)context).overridePendingTransition(R.anim.open_enter, R.anim.open_exit);
    }
}

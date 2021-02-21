package com.classes.ejnu.utils;

import com.classes.ejnu.VO.ResultVO;

public class ResultVoUtil {

    public static ResultVO success(Object object)
    {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }

    public static ResultVO success()
    {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg)
    {
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(msg);
        resultVO.setCode(code);

        return resultVO;
    }
}

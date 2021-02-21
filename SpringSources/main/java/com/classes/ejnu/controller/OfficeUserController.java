package com.classes.ejnu.controller;


import com.classes.ejnu.dataobject.Office;
import com.classes.ejnu.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("office")
public class OfficeUserController {

    @Autowired
    private OfficeService officeService;


    @GetMapping("/index")
    public ModelAndView officeindex() {
        return new ModelAndView("office/login");
    }


    @PostMapping("/login")
    public ModelAndView login(@Valid Office office,
                              BindingResult bindingResult,
                              HttpServletResponse response,
                              HttpServletRequest request,
                              Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/ejnu/office/account/list");
            return new ModelAndView("common/error", map);
        }

        String id = office.getOfficeId();
        Office realaccount = officeService.findOne(id);

        if(realaccount == null || (!realaccount.getOfficePassword().equals(office.getOfficePassword())) )
        {
            map.put("msg", "密码错误或用户不存在");
            map.put("url", "/ejnu/office/index");
            return new ModelAndView("common/error", map);
        }

        request.getSession().setAttribute("users", id);

        map.put("url", "/ejnu/office/account/list");
        return new ModelAndView("common/success", map);
    }
}

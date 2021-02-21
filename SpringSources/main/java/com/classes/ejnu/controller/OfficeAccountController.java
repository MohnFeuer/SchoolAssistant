package com.classes.ejnu.controller;


import com.classes.ejnu.dataobject.Office;
import com.classes.ejnu.enums.ResultEnum;
import com.classes.ejnu.service.OfficeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;
import java.util.Objects;

@Controller
@RequestMapping("office/account")
@Slf4j
public class OfficeAccountController {


    /*教务管理员*/
    @Autowired
    private OfficeService officeService;

    /**
     * 管理列表
     * @param page 当前页
     * @param size 每页大小
     * @param map 参数
     * @return office/list
     */
    @GetMapping("/list")
    public ModelAndView officelist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                  @RequestParam(value = "size", defaultValue = "10") Integer size,
                                  Map<String, Object> map){
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Office> officePage = officeService.findAll(request);
        map.put("officePage", officePage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("office/list", map);
    }

    /**
     * 删除管理
     * @param officeId 管理号
     * @param map 参数
     * @return common/success
     */
    @GetMapping("/delete")
    public ModelAndView officedelete(@RequestParam("officeId") String officeId,
                                    Map<String, Object> map){

        officeService.delete(officeId);

        map.put("msg", ResultEnum.CANCEL_SUCCESS.getMessage());
        map.put("url", "/ejnu/office/account/list");
        return new ModelAndView("common/success");
    }


    @GetMapping("/detail")
    public ModelAndView officedetail(@RequestParam(value = "officeId", required = false) String officeId,
                                    Map<String, Object> map) {

        Office office = new Office();

        //officeId不为空，是修改操作
        if (officeId != null)
            office = officeService.findOne(officeId);

        map.put("office", office);
        return new ModelAndView("office/detail", map);
    }


    @PostMapping("/save")
    public ModelAndView officesave(@Valid Office office,
                                  BindingResult bindingResult,
                                  Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/ejnu/office/account/list");
            return new ModelAndView("common/error", map);
        }

        officeService.save(office);

        map.put("url", "/ejnu/office/account/list");
        return new ModelAndView("common/success", map);
    }


}

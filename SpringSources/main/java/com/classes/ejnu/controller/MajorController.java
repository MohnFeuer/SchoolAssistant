package com.classes.ejnu.controller;

import com.classes.ejnu.dataobject.Major;
import com.classes.ejnu.enums.ResultEnum;
import com.classes.ejnu.repository.MajorRepository;
import com.classes.ejnu.service.MajorService;
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
@RequestMapping("office/major")
@Slf4j
public class MajorController {

    /*专业*/
    @Autowired
    private MajorService majorService;

    /**
     * 专业列表
     * @param page 当前页
     * @param size 每页大小
     * @param map 参数
     * @return major/list
     */
    @GetMapping("/list")
    public ModelAndView majorlist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size,
                                 Map<String, Object> map){
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Major> majorPage = majorService.findAll(request);
        map.put("majorPage", majorPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("major/list", map);
    }

    /**
     * 删除专业
     * @param majorId 专业号
     * @param map 参数
     * @return common/success
     */
    @GetMapping("/delete")
    public ModelAndView majordelete(@RequestParam("majorId") Integer majorId,
                                   Map<String, Object> map){

        majorService.delete(majorId);

        map.put("msg", ResultEnum.CANCEL_SUCCESS.getMessage());
        map.put("url", "/ejnu/office/major/list");
        return new ModelAndView("common/success");
    }


    @GetMapping("/detail")
    public ModelAndView majordetail(@RequestParam(value = "majorId", required = false) Integer majorId,
                                   Map<String, Object> map) {

        Major major = new Major();

        //majorId不为空，是修改操作
        if (majorId != null)
            major = majorService.findOne(majorId);

        map.put("major", major);
        return new ModelAndView("major/detail", map);
    }


    @PostMapping("/save")
    public ModelAndView majorsave(@Valid Major major,
                                 BindingResult bindingResult,
                                 Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/ejnu/office/major/list");
            return new ModelAndView("common/error", map);
        }

        majorService.save(major);

        map.put("url", "/ejnu/office/major/list");
        return new ModelAndView("common/success", map);
    }

}

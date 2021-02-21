package com.classes.ejnu.controller;


import com.classes.ejnu.dataobject.Book;
import com.classes.ejnu.dataobject.Contest;
import com.classes.ejnu.dataobject.Exam;
import com.classes.ejnu.enums.ResultEnum;
import com.classes.ejnu.service.BookService;
import com.classes.ejnu.service.ContestService;
import com.classes.ejnu.service.ExamService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
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
@RequestMapping("/office/data")
@Slf4j
public class OfficeDataController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ExamService examService;

    @Autowired
    private ContestService contestService;

    /*书籍*/

    /**
     * 书籍列表
     * @param page 当前页
     * @param size 每页大小
     * @param map 参数
     * @return data/book/list
     */
    @GetMapping("/book/list")
    public ModelAndView booklist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map){
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Book> bookPage = bookService.findAll(request);
        map.put("bookPage", bookPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("data/book/list", map);
    }

    /**
     * 删除书籍
     * @param bookId 书号
     * @param map 参数
     * @return common/success
     */
    @GetMapping("/book/delete")
    public ModelAndView bookdelete(@RequestParam("bookId") Integer bookId,
                               Map<String, Object> map){

        bookService.delete(bookId);

        map.put("msg", ResultEnum.CANCEL_SUCCESS.getMessage());
        map.put("url", "/ejnu/office/data/book/list");
        return new ModelAndView("common/success");
    }


    @GetMapping("/book/detail")
    public ModelAndView bookdetail(@RequestParam(value = "bookId", required = false) Integer bookId,
                               Map<String, Object> map) {

        Book book = new Book();

        //令book已经包含书籍详情
        if (bookId != null)
            book = bookService.findOne(bookId);

        map.put("book", book);
        return new ModelAndView("data/book/detail", map);
    }


    @PostMapping("/book/save")
    public ModelAndView booksave(@Valid Book book,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/ejnu/office/data/book/list");
            return new ModelAndView("common/error", map);
        }

        bookService.save(book);

        map.put("url", "/ejnu/office/data/book/list");
        return new ModelAndView("common/success", map);
    }

    /*--------------------------------------------------------------------------------------------------------------*/
    /*考试*/

    /**
     * 考试列表
     * @param page 当前页
     * @param size 每页大小
     * @param map 参数
     * @return data/exam/list
     */
    @GetMapping("/exam/list")
    public ModelAndView examlist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map){
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Exam> examPage = examService.findAll(request);
        map.put("examPage", examPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("data/exam/list", map);
    }

    /**
     * 删除书籍
     * @param examId 书号
     * @param map 参数
     * @return common/success
     */
    @GetMapping("/exam/delete")
    public ModelAndView examdelete(@RequestParam("examId") Integer examId,
                               Map<String, Object> map){

        examService.delete(examId);

        map.put("msg", ResultEnum.CANCEL_SUCCESS.getMessage());
        map.put("url", "/ejnu/office/data/exam/list");
        return new ModelAndView("common/success");
    }


    @GetMapping("/exam/detail")
    public ModelAndView examdetail(@RequestParam(value = "examId", required = false) Integer examId,
                               Map<String, Object> map) {

        Exam exam = new Exam();

        //令Exam已经包含书籍详情
        if (examId != null)
            exam = examService.findOne(examId);

        map.put("exam", exam);
        return new ModelAndView("data/exam/detail", map);
    }


    @PostMapping("/exam/save")
    public ModelAndView examsave(@Valid Exam exam,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/ejnu/office/data/exam/list");
            return new ModelAndView("common/error", map);
        }

        examService.save(exam);

        map.put("url", "/ejnu/office/data/exam/list");
        return new ModelAndView("common/success", map);
    }


    /*--------------------------------------------------------------------------------------------------------------*/
    /*竞赛*/

    /**
     * 竞赛列表
     * @param page 当前页
     * @param size 每页大小
     * @param map 参数
     * @return data/contest/list
     */
    @GetMapping("/contest/list")
    public ModelAndView contestlist(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                 @RequestParam(value = "size", defaultValue = "10") Integer size,
                                 Map<String, Object> map){
        PageRequest request = PageRequest.of(page - 1, size);
        Page<Contest> contestPage = contestService.findAll(request);
        map.put("contestPage", contestPage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("data/contest/list", map);
    }

    /**
     * 删除书籍
     * @param contestId 书号
     * @param map 参数
     * @return common/success
     */
    @GetMapping("/contest/delete")
    public ModelAndView contestdelete(@RequestParam("contestId") Integer contestId,
                                   Map<String, Object> map){

        contestService.delete(contestId);

        map.put("msg", ResultEnum.CANCEL_SUCCESS.getMessage());
        map.put("url", "/ejnu/office/data/contest/list");
        return new ModelAndView("common/success");
    }


    @GetMapping("/contest/detail")
    public ModelAndView contestdetail(@RequestParam(value = "contestId", required = false) Integer contestId,
                                   Map<String, Object> map) {

        Contest contest = new Contest();

        //令contest已经包含书籍详情
        if (contestId != null)
            contest = contestService.findOne(contestId);

        map.put("contest", contest);
        return new ModelAndView("data/contest/detail", map);
    }


    @PostMapping("/contest/save")
    public ModelAndView contestsave(@Valid Contest contest,
                                 BindingResult bindingResult,
                                 Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
            map.put("url", "/ejnu/office/data/contest/list");
            return new ModelAndView("common/error", map);
        }

        contestService.save(contest);

        map.put("url", "/ejnu/office/data/contest/list");
        return new ModelAndView("common/success", map);
    }


}

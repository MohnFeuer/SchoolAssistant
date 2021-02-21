package com.classes.ejnu.usercontroller;

import com.classes.ejnu.VO.ResultVO;
import com.classes.ejnu.dataobject.Book;
import com.classes.ejnu.dataobject.Contest;
import com.classes.ejnu.dataobject.Exam;
import com.classes.ejnu.service.BookService;
import com.classes.ejnu.service.ContestService;
import com.classes.ejnu.service.ExamService;
import com.classes.ejnu.utils.ResultVoUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user/data")
public class DataController {


    @Autowired
    private BookService bookService;

    @Autowired
    private ExamService examService;

    @Autowired
    private ContestService contestService;

    /*书籍*/

    /**
     * 书籍列表
     * @return List<Book> bookList
     */
    @GetMapping("/book/list")
    public ResultVO booklist(){

        List<Book> bookList = bookService.findAll();
        return ResultVoUtil.success(bookList);
    }

    /*考试*/

    /**
     * 考试列表
     * @return List<Exam> examList
     */
    @GetMapping("/exam/list")
    public ResultVO examlist(){

        List<Exam> examList = examService.findAll();
        return ResultVoUtil.success(examList);
    }

    /*竞赛*/
    /**
     * 竞赛列表
     * @return List<Contest> contestList
     */
    @GetMapping("/contest/list")
    public ResultVO contestlist(){

        List<Contest> contestList  = contestService.findAll();
        return ResultVoUtil.success(contestList);
    }
}

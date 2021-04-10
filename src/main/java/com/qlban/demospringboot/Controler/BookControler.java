package com.qlban.demospringboot.Controler;


import com.qlban.demospringboot.Conveter.SachConveter;
import com.qlban.demospringboot.Models.SachModel;
import com.qlban.demospringboot.Repositorys.Entitys.SachEntity;
import com.qlban.demospringboot.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "book")
public class BookControler {

    @Autowired
    BookService bookService;

    @Autowired
    SachConveter sachConveter;


    @GetMapping(value = "/type")
    public List<SachModel> findByType(@RequestParam(name = "nameType") String nameType) {
        List<SachModel> sachModelList = null;
        List<SachEntity> sachEntityList ;
        try {
            sachEntityList = bookService.findByCategory(nameType);
            for (SachEntity s : sachEntityList) {
                sachModelList.add(sachConveter.toModel(s));
            }

        } catch (Exception e) {
            return null;
        }
        return sachModelList;
    }

    @PostMapping(value = "/add/{id}")
    public void addBook(@RequestBody SachModel sachModel,
                        @PathVariable(name = "id") int id) {
        SachEntity sachEntity = sachConveter.toEntity(sachModel);
        bookService.addBook(sachEntity,id);
    }

    @PutMapping(value = "/infor")
    public void updateBook(@RequestBody SachModel sachModel) {
        SachEntity sachEntity = sachConveter.toEntity(sachModel);
        bookService.update(sachEntity);
    }

    @GetMapping(value = "/showBookS/{id}")
    public List<SachModel> listBookS(@PathVariable int id) {
        try {
            return sachConveter.
                    toBookModelList(bookService.
                            getBookListUs(id));
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping(value = "/listFavorite/{id}")
    public List<SachModel> listFavorite(@PathVariable int id) {
        List<SachEntity> sachEntityList ;
        try {
            sachEntityList = bookService.listFavorite(id);
        } catch (Exception e) {
            return null;
        }
        return sachConveter.toBookModelList(sachEntityList);
    }

    @GetMapping(value = "/sortByPrice")
    public List<SachModel> sortByPrice(@RequestParam(name = "choose", defaultValue = "1") String choose) {
        List<SachModel> sachModelList = null;
        List<SachEntity> sachEntityList ;
            sachEntityList = bookService.findAllOrderByGiaban(choose);
            for (SachEntity s : sachEntityList) {
                sachModelList.add(sachConveter.toModel(s));
            }
        return sachModelList;
    }

    @DeleteMapping(value = "/delete")
    public void deleteBook(@RequestBody int id) {
        bookService.deleteOneById(id);
    }

    @GetMapping(value = "/author-list")
    public List<SachEntity> bookListByAuthor(
            @RequestParam(name = "author") String author) {
        List<SachEntity> bookList = null;
        try {
            bookList = bookService.findByAuthor(author);
        } catch (Exception e) {
            err();
        }
        return bookList;
    }

    @GetMapping(value = "/403")
    public Object err() {
        return "403";
    }
}

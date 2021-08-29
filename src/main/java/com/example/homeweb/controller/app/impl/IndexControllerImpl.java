package com.example.homeweb.controller.app.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.homeweb.controller.app.IndexController;

@Controller // (1)
@RequestMapping("/top")
public class IndexControllerImpl implements IndexController{

	/**
	* Thymeleaf 基本編
	*
	* @param mav
	* ModelAndViewクラス テンプレートで利用するデータ類とビューに関する情報をまとめて管理するクラス
	* @return
	*/
    @RequestMapping("/")
    public ModelAndView index(ModelAndView mav) {

        // 1.(1) 変数式
        // ・コントローラーからテンプレートに値を渡す
        // ・変数「msg」に値を設定
        mav.addObject("msg", "コントローラーからテンプレートに値を渡す");

        // 使用するビューを設定
        mav.setViewName("/top/index"); // (3)

        return mav;
    }

}
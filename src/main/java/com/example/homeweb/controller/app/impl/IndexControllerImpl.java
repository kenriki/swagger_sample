package com.example.homeweb.controller.app.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.homeweb.controller.app.IndexController;



@Controller // (1)
@RequestMapping("/")
public class IndexControllerImpl implements IndexController {

  /**
   * TOPページ.
   *
   * @param mav ModelAndViewクラス テンプレートで利用するデータ類とビューに関する情報をまとめて管理するクラス
   * @return
   */
  @RequestMapping("/")
  public ModelAndView topInit(ModelAndView mav) {

    // 1.(1) 変数式
    // ・コントローラーからテンプレートに値を渡す
    // ・変数「msg」に値を設定
    mav.addObject("msg", "TOPページ");

    // 使用するビューを設定
    mav.setViewName("/index"); // (3)

    return mav;
  }

  /**
   * Sub1ページ.
   *
   * @param mav ModelAndViewクラス テンプレートで利用するデータ類とビューに関する情報をまとめて管理するクラス
   * @return
   */
  @RequestMapping("/subPage1")
  public ModelAndView subInit(ModelAndView mav) {

    // 1.(1) 変数式
    // ・コントローラーからテンプレートに値を渡す
    // ・変数「msg」に値を設定
    mav.addObject("msg", "コントローラーからテンプレートに値を渡す");

    // 使用するビューを設定
    mav.setViewName("/sub/index"); // (3)

    return mav;
  }

}
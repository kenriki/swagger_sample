package com.example.homeweb.controller.app;

import org.springframework.web.servlet.ModelAndView;

/**
 * TOPページ用Controller.
 *
 * @author user
 *
 */
public interface IndexController {
  /**
   * TOPページ初期表示.
   *
   * @param mav ModelAndView
   * @return model ModelAndView
   */
  public ModelAndView topInit(ModelAndView mav);

  /**
   * SUBページ初期表示.
   *
   * @param mav ModelAndView
   * @return model ModelAndView
   */
  public ModelAndView subInit(ModelAndView mav);
}

package com.icontrols.test;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	UserService UserService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}
	
    /*
     * move to join.jsp
     * @return ModelAndView 
     */
	@RequestMapping("joinPage.do")
	public ModelAndView joinPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("join");
		return mav;
	}

    /*
     * insert DB and move to home.jsp
     * @RequestParam uId (String) user's ID
     * @RequestParamu Pwd (String) user's Password
     * @RequestParam uPhone (String) user's PhoneNumber
     * @return ModelAndView 
     */
	@RequestMapping("join.do")
	public ModelAndView join(@RequestParam(value = "u_id") String uId, @RequestParam(value = "u_pwd") String uPwd,
			@RequestParam(value = "u_phone") String uPhone) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("uId", uId);
		map.put("uPwd", uPwd);
		map.put("uPhone", uPhone);
		UserService.insertUser(map);
		return mav;
	}

    /*
     * move to login.jsp
     * @return ModelAndView 
     */
	@RequestMapping("loginPage.do")
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

    /*
     * selectDB for login and if(correct) move to success.jsp else move to fail.jsp
     * @RequestParam uId (String) user's ID
     * @RequestParamu Pwd (String) user's Password
     * @return ModelAndView 
     */
	@RequestMapping("login.do")
	public ModelAndView login(@RequestParam(value = "u_id") String uId, @RequestParam(value = "u_pwd") String uPwd) {
		ModelAndView mav = new ModelAndView();
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("uId", uId);
		map.put("uPwd", uPwd);
		
		/*
		 * to check user's Id and user's pwd
		 * @return success : return 1 / fail : return 0
		 */
		int loginCheck = UserService.loginCheck(map); 
		
		if (loginCheck == 1) {
			mav.setViewName("success");
		} else {
			mav.setViewName("fail");
		}
		return mav;
	}
}

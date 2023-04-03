package leejy.myapp.api.myapp.controller;

import leejy.myapp.api.common.exception.ClockException;
import leejy.myapp.api.myapp.model.Mytime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Locale;

@Controller
public class TimeController2 {
	private static final Logger logger = LoggerFactory.getLogger(TimeController2.class);

	@RequestMapping(value = { "/time2" }, method = { RequestMethod.GET })
	public @ResponseBody Mytime time(Locale locale, Model model) throws ClockException {

		Date date = new Date();
		Mytime mt = new Mytime();

		/* 1. insert data into model */
		mt.setNow(date.toString());
		logger.info("[TimeController2] mt is... {}", mt.toString());

		String str = "";

		/* 2. return result */
		return mt;
	}
}

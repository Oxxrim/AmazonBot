package org.itstep;

import java.util.ArrayList;


import org.itstep.dao.AccountDAO;
import org.itstep.dao.ActionDAO;
import org.itstep.model.AccRandomizer;
import org.itstep.model.Account;
import org.itstep.model.Action;
import org.itstep.service.ImitatorService;
import org.itstep.service.Timer;
import org.openqa.selenium.WebDriver;

public class AppRunner {

	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			ImitatorService imService = new ImitatorService();
			AccountDAO accountDAO = new AccountDAO();
			AccRandomizer accRand = new AccRandomizer();
			Action act = new Action();
			ActionDAO actiondao = new ActionDAO();
			Account acc = new Account(accRand.getName(), accRand.getEmail(), accRand.getPassword());
			act.setLogin(acc.getName());
			WebDriver driver = imService.registerAmazonAccount(acc);
			accountDAO.save(acc);
			ArrayList<String> asins = accountDAO.getAsin();
			Timer.waitSeconds(10);

			int j = 0;
			for (String string : asins) {
				act.setAsin(string);
				if (j % 2 == 0) {
					driver = imService.addItemToCart(driver, string);
					act.setAdd("+");
				} else {
					act.setAdd("-");
				}
				
				act.setTime(System.currentTimeMillis());

				actiondao.save(act);
				j++;
			}

			driver.quit();
		}
	}

}

package bdbt_proj_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

	@Autowired
	private PortDAO dao;

	@RequestMapping("/")
	public String viewHomePage(Model model) {

		List<Port> listPort = dao.list();
		model.addAttribute("listPort", listPort);
		return "index";
	}

}

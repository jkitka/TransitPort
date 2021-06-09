package bdbt_proj_2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {

	@Autowired
	private PortDAO dao;

	@RequestMapping("/table.html")
	public String viewTablePageFor(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentUser = authentication.getName();
		System.out.println(currentUser);
		List<Port> listPort;
		if (currentUser.equals("admin")) {
			listPort = dao.list();
		} else {
			listPort = dao.listAsBasic();
		}

		model.addAttribute("listPort", listPort);
		return "table" + currentUser;
	}

	@RequestMapping("/")
	public String vievHomePage(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String role = authentication.getName();
		if (role.equals("anonymousUser")) {
			model.addAttribute("state", "Zaloguj siê");
		} else {
			model.addAttribute("state", "Wyloguj siê");
		}

		return "index";
	}

	@RequestMapping("/about.html")
	public String vievAboutPage(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String role = authentication.getName();
		if (role.equals("anonymousUser")) {
			model.addAttribute("state", "Zaloguj siê");
		} else {
			model.addAttribute("state", "Wyloguj siê");
		}

		return "about";
	}

	@RequestMapping("/index.html")
	public String vievMainPage(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String role = authentication.getName();
		if (role.equals("anonymousUser")) {
			model.addAttribute("state", "Zaloguj siê");
		} else {
			model.addAttribute("state", "Wyloguj siê");
		}

		return "index";
	}

	@RequestMapping("/contact.html")
	public String vievContactPage(Model model) {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String role = authentication.getName();
		if (role.equals("anonymousUser")) {
			model.addAttribute("state", "Zaloguj siê");
		} else {
			model.addAttribute("state", "Wyloguj siê");
		}

		return "contact";
	}

	@RequestMapping("/new")
	public String showNewForm(Model model) {

		Port port = new Port();
		model.addAttribute("port", port);
		return "hiring";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("port") Port port) {

		dao.save(port);
		return "redirect:/table.html";
	}

	@RequestMapping("/edit/{id_portu}")
	public ModelAndView showEditForm(@PathVariable(name = "id_portu") int id_portu) {
		ModelAndView mav = new ModelAndView("edit_form");
		Port port = dao.get(id_portu);
		mav.addObject("port", port);

		return mav;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)

	public String update(@ModelAttribute("port") Port port) {
		dao.update(port);
		return "redirect:/table.html";
	}

	@RequestMapping("/delete/{id_portu}")
	public String delete(@PathVariable(name = "id_portu") int id_portu) {
		dao.delete(id_portu);
		return "redirect:/table.html";

	}

}

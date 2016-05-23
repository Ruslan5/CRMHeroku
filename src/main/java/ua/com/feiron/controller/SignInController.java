package ua.com.feiron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.feiron.domain.SignInForm;
import ua.com.feiron.repository.SignInRepository;
import ua.com.feiron.validation.SignInValidator;

@Controller
@RequestMapping("signup")
public class SignInController {
    private SignInValidator signInValidator;
    private SignInRepository signInRepository;

    @Autowired
    public SignInController(SignInValidator signInValidator, SignInRepository signInRepository){
        this.signInValidator = signInValidator;
        this.signInRepository = signInRepository;
    }


//    @RequestMapping(method = RequestMethod.GET)
////	@PreAuthorize("isAuthenticated()")
//    public String addProduct(ModelMap model){
//        model.addAttribute("signInForm", new SignInForm());
////        model.addAttribute("massage", new SignInForm().getUsername());
//        return "signup";
//    }
	@RequestMapping(method = RequestMethod.GET)
	public String signup(ModelMap model) {
		SignInForm signInForm = new SignInForm();
		model.put("signInForm", signInForm);
		return "signup";
	}

    @RequestMapping(method = RequestMethod.POST)
    public String processSignup(@ModelAttribute("signInForm") SignInForm signInForm, BindingResult result) {
        signInValidator.validate(signInForm, result);
        if (result.hasErrors()) {
            return "signup";
        }
        this.signInRepository.addsignup(signInForm);
        return "signup-success";
    }

}

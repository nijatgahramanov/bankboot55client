package az.orient.bankboot55client.controller;

import az.orient.bankboot55client.api.request.ReqUser;
import az.orient.bankboot55client.api.response.RespUser;
import az.orient.bankboot55client.util.Utility;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class LoginController {

    ObjectMapper objectMapper = new ObjectMapper();

    private final Utility utility;
    private final HttpServletRequest request;

    @Value("${api.url}")
    String apiUrl;


    @GetMapping(value = {"/", "/loginView"})
    public ModelAndView loginView(@RequestParam(value = "msg", required = false) String msg) {
        ModelAndView model = new ModelAndView("login");
        model.addObject("msg", msg);
        return model;
    }
    @PostMapping("/login")
    public RedirectView login(@RequestParam("username") String username,
                              @RequestParam("password") String password) {

        RedirectView redirectView = null;
        try {
            if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
                ReqUser reqUser = new ReqUser();
                reqUser.setUsername(username);
                reqUser.setPassword(password);
                String reqUserJson = objectMapper.writeValueAsString(reqUser);
                String result = utility.sendPost(apiUrl + "user/login", reqUserJson);
                RespUser respUser = objectMapper.readValue(result, RespUser.class);
                if (respUser.getStatus().getCode() == 1 || respUser.getStatus().getCode()==107) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("respUser", respUser);
                    redirectView = new RedirectView("/client/getCustomerList");
                } else {
                    redirectView = new RedirectView("/client/loginView");
                    redirectView.addStaticAttribute("msg", respUser.getStatus().getMessage());
                }
            } else {
                redirectView = new RedirectView("/client/loginView");
                redirectView.addStaticAttribute("msg", "Username or password is empty");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return redirectView;
    }


}

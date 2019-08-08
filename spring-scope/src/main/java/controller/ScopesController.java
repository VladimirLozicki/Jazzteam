package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import request.MessageRequest;

import javax.annotation.Resource;


@Controller
public class ScopesController {

    @Resource(name = "printMessageRequest")
    private MessageRequest messageRequest;

    @GetMapping("/")
    public String getRequestScopeMessage(Model model) {
        model.addAttribute("previousMessage", messageRequest.getMessage());
        messageRequest.setMessage("Hello");
        model.addAttribute("currentMessage", messageRequest.getMessage());
        return "scopesExample";
    }
}

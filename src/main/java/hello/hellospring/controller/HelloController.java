package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello"; // resources/templates에서 리턴값 파일을 찾아서 맵핑시켜라
    }

    @GetMapping("hello-mvc")
    public String HelloMvc(@RequestParam(value = "name", required = true) String name, Model model)
    {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String HelloString(@RequestParam(value="name") String name, Model model)
    {
        return "hello" + name;
    }

    static class Hello {
        private String name;

        public String getName()
        {
            return this.name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

    }
    @GetMapping("hello-api")
    @ResponseBody
    //Model이 필요 없음
    public Hello helloApi(@RequestParam(value="name") String name)
    {
        Hello hello = new Hello();
        hello.setName(name);
        return hello; //객체 반환
    }


}

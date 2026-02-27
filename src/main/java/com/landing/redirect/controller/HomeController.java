package com.landing.redirect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@RequestParam(value = "gclid", required = false) String gclid) {
        // Redirect nếu URL có chứa tham số gclid (dù có gán giá trị hay không, ví dụ: /?gclid)
        if (gclid != null) {
            return "redirect:https://elementor.com/pricing/?cxd=215992_957726&utm_source=elementor&utm_medium=affiliate&utm_campaign=215992&utm_content=cx&affid=215992";
        }
        return "index";
    }

    // Hỗ trợ cả đường dẫn có và không có dấu gạch chéo ở cuối ( /plugin và /plugin/ )
    @GetMapping({"/plugin", "/plugin/"})
    public String plugin(@RequestParam(value = "gclid", required = false) String gclid) {
        // Nếu muốn gclid ở bất kỳ đâu cũng redirect, ta xử lý luôn ở đây
        if (gclid != null) {
            return "redirect:https://elementor.com/pricing/?cxd=215992_957726&utm_source=elementor&utm_medium=affiliate&utm_campaign=215992&utm_content=cx&affid=215992";
        }
        return "plugin";
    }
}

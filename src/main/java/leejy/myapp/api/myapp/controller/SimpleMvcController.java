package leejy.myapp.api.myapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleMvcController {

    @PostMapping(value = "/regPage")
    @ResponseBody
    public String getPageInfo (
            @RequestParam(value = "pageName") String pageName
            , @RequestParam(value = "pageNo", required = true) int pageNo
            , @RequestParam(value = "pageDetail", required = false) String pageDetail
            , @RequestParam(value = "userNo", required = false) int userNo
    ) {
        System.out.println("[SimpleMvcController] pageName : ["+pageName+"]");
        System.out.println("[SimpleMvcController] pageNo : ["+pageNo+"]");
        System.out.println("[SimpleMvcController] pageDetail(required = false) : ["+pageDetail+"]");
        System.out.println("[SimpleMvcController] userNo(required = false) : ["+userNo+"]");

        String pageInfo = "page";
        return pageInfo;
    }
}

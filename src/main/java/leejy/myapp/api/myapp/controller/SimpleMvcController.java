package leejy.myapp.api.myapp.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class SimpleMvcController {

    private static final Logger logger = LoggerFactory.getLogger(SimpleMvcController.class);

    @PostMapping(value = "/regPage")
    @ResponseBody
    public String getPageInfo (
            @RequestParam(value = "pageName") String pageName
            , @RequestParam(value = "pageNo", required = true) int pageNo
            , @RequestParam(value = "pageDetail", required = false) String pageDetail
//            , @RequestParam(value = "userNo", required = false) int userNo
            , @RequestParam(value = "userNo", required = false) Integer userNo
    ) {
        System.out.println("[SimpleMvcController] pageName : ["+pageName+"]");
        System.out.println("[SimpleMvcController] pageNo : ["+pageNo+"]");
        System.out.println("[SimpleMvcController] pageDetail(required = false) : ["+pageDetail+"]");
        System.out.println("[SimpleMvcController] userNo(required = false) : ["+userNo+"]");

        /*
        key 값에 userNo가 아예 없을 경우, required = false로 지정되어 있다하더라도 int일 경우 에러가 난다. null로 정의할 수 없기 떄문. 이 경우 Integer라면 null로 정의된다.
        반면 String은 없을 경우 문제 되지 않고, null 로 정의 된다. (empty String이 아니다.)
        Sysout이나 logger로 pageDetail을 찍으면 null이 나오고 NPE는 발생하지 않는다. 그러나 .length()를 한다면 NPE가 난다.
        */

        String pageInfo = "page";
        return pageInfo;
    }
}

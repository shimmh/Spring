package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members")
public class SpringMemberControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    // String으로 작성하면 viewname으로 인식한다.
    //@RequestMapping(value="/new-form", method = RequestMethod.GET)
    @GetMapping("/new-form")
    public String newForm() {
        return"new-form";
    }

    // 어노테이션 기반 컨트롤러는 HttpServletRequest, HttpServletResponse 또는 파라미터를 직접 받을 수(@RequestParam)도 있다.
    //@RequestMapping(value="/save", method = RequestMethod.POST)
    @PostMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);
        return "save-result";
    }

    //@RequestMapping(method=RequestMethod.GET)
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();

        model.addAttribute("members", members);
        return "members";
    }
}

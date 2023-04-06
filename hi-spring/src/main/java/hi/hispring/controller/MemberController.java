package hi.hispring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import hi.hispring.domain.Member;
import hi.hispring.service.MemberService;

@Controller
public class MemberController {

    private final MemberService memberservice;

    @Autowired
    public MemberController(MemberService memberservice) {
        this.memberservice = memberservice;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberservice.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String getList(Model model) {
        List<Member> memberList = memberservice.findMembers();
        model.addAttribute("members", memberList);

        return "members/memberList";
    }
}

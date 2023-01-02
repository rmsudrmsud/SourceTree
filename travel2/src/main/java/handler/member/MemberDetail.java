package handler.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import handler.Handler;
import member.MemberService;
import member.MemberVo;

public class MemberDetail implements Handler {

   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) {
      // TODO Auto-generated method stub
      String id = request.getParameter("id");
      String tel=request.getParameter("tel");
            
      if(request.getMethod().toLowerCase().equals("get")) {
         MemberService service = new MemberService();
         MemberVo vo = service.getMember(id);
         //검색 결과를 request에 담는다
         request.setAttribute("vo", vo);
         return "/member/detail.jsp";
      }
         
      String pwd = request.getParameter("pwd");
      MemberService service = new MemberService();
      service.editMember(new MemberVo(id, pwd, null, tel, null, null));
      return "redirect:/index.jsp";
   }

}
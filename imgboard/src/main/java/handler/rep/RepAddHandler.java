package handler.rep;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import handler.Handler;
import rep.RepService;
import rep.RepVo;

public class RepAddHandler implements Handler {

   @Override
   public String process(HttpServletRequest request, HttpServletResponse response) {
      try {
         request.setCharacterEncoding("utf-8");
         response.setCharacterEncoding("utf-8");
         response.setContentType("text/html; charset=utf-8");
         
      } catch (UnsupportedEncodingException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      int parent = Integer.parseInt(request.getParameter("parent"));
      String writer = request.getParameter("writer");
      String content = request.getParameter("content");
      
      RepService service = new RepService();
      service.addRep(new RepVo(0, writer, content, parent));
      
      ArrayList<RepVo> list = service.getAll(parent);
      JSONArray arr = new JSONArray();
      for(RepVo r: list) {
         JSONObject obj = new JSONObject();
         obj.put("num", r.getNum());
         obj.put("writer", r.getWriter());
         obj.put("content", r.getContent());
         obj.put("parent", r.getParent());
         arr.add(obj);
      }
      
      String txt = arr.toJSONString();
      System.out.println(txt);
      return "responsebody/" + txt;
   }

}
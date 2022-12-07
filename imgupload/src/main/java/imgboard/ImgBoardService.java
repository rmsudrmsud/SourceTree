package imgboard;

import java.util.ArrayList;

public class ImgBoardService {
   private ImgBoardDao dao;
   public ImgBoardService() {
      dao = new ImgBoardDao();
      
   }
   public void addImgBoard(ImgBoardVo vo) {
      dao.insert(vo);
   }
   
   public ImgBoardVo getImgBoard(int num) {
      return dao.select(num);
   }
   
   public ArrayList<ImgBoardVo> getAll(){
      return dao.selectAll();
   }
   
   public void editImgBoard(ImgBoardVo vo) {
      dao.update(vo);
   }
   public void delImgBoard(int num) {
      dao.delete(num);
   }
   
}
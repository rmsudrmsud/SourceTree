package download;

import java.util.ArrayList;

public class DownloadService {
	private DownloadDao dao;
	
	public DownloadService() {
		dao = new DownloadDao();
	}
	
	public void addDownload(DownloadVo vo) {
		dao.insert(vo);
	}
	
	public DownloadVo getDownload(int num) {
		return dao.select(num);
	}
	
	public ArrayList<DownloadVo> getAll(){
		return dao.selectAll();
	}
	
	public ArrayList<DownloadVo> getByPath(String down_path) {
		return dao.selectByPath(down_path);
	}
	
	public void editDownload(DownloadVo vo) {
		dao.update(vo);
	}
	
	public void addCnt(int down_cnt) {
		dao.updateCnt(down_cnt);
	}
	
	public void delDownload(int num) {
		dao.delete(num);
	}
}

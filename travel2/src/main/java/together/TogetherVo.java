package together;

import java.sql.Date;
import java.util.ArrayList;

import togetherRep.TogetherRepVo;



public class TogetherVo {
 private int travel_num;
 private int city_num;
 private String id;
 private String title;
 private String content;
 private int ppl;
 private Date wdate;
 private ArrayList<TogetherRepVo> reps;
 
 public TogetherVo() {
	 
 }



public TogetherVo(int travel_num, int city_num, String id, String title, String content, int ppl, Date wdate) {
	
	this.travel_num = travel_num;
	this.city_num = city_num;
	this.id = id;
	this.title = title;
	this.content = content;
	this.ppl = ppl;
	this.wdate = wdate;
	
}



/**
 * @return the travel_num
 */
public int getTravel_num() {
	return travel_num;
}



/**
 * @param travel_num the travel_num to set
 */
public void setTravel_num(int travel_num) {
	this.travel_num = travel_num;
}



/**
 * @return the city_num
 */
public int getCity_num() {
	return city_num;
}



/**
 * @param city_num the city_num to set
 */
public void setCity_num(int city_num) {
	this.city_num = city_num;
}



/**
 * @return the id
 */
public String getId() {
	return id;
}



/**
 * @param id the id to set
 */
public void setId(String id) {
	this.id = id;
}



/**
 * @return the title
 */
public String getTitle() {
	return title;
}



/**
 * @param title the title to set
 */
public void setTitle(String title) {
	this.title = title;
}



/**
 * @return the content
 */
public String getContent() {
	return content;
}



/**
 * @param content the content to set
 */
public void setContent(String content) {
	this.content = content;
}



/**
 * @return the ppl
 */
public int getPpl() {
	return ppl;
}



/**
 * @param ppl the ppl to set
 */
public void setPpl(int ppl) {
	this.ppl = ppl;
}



/**
 * @return the wdate
 */
public Date getWdate() {
	return wdate;
}



/**
 * @param wdate the wdate to set
 */
public void setWdate(Date wdate) {
	this.wdate = wdate;
}



/**
 * @return the reps
 */
public ArrayList<TogetherRepVo> getReps() {
	return reps;
}



/**
 * @param reps the reps to set
 */
public void setReps(ArrayList<TogetherRepVo> reps) {
	this.reps = reps;
}



@Override
public String toString() {
	return "TogetherVo [travel_num=" + travel_num + ", city_num=" + city_num + ", id=" + id + ", title=" + title
			+ ", content=" + content + ", ppl=" + ppl + ", wdate=" + wdate + "]";
}


}
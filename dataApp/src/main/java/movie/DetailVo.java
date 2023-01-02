package movie;

public class DetailVo {
	private String movieNm;
	private int showTm;
	private int openDt;
	private String director;
	private String actor;
	private String actor2;
	private String cast;
	
	public DetailVo() {}
	public DetailVo(String movieNm, int showTm, int openDt, String director, String actor, String actor2, String cast) {
		
		this.movieNm = movieNm;
		this.showTm = showTm;
		this.openDt = openDt;
		this.director = director;
		this.actor = actor;
		this.actor2 = actor2;
		this.cast = cast;
	}
	public String getMovieNm() {
		return movieNm;
	}
	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}
	public int getShowTm() {
		return showTm;
	}
	public void setShowTm(int showTm) {
		this.showTm = showTm;
	}
	public int getOpenDt() {
		return openDt;
	}
	public void setOpenDt(int openDt) {
		this.openDt = openDt;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getActor2() {
		return actor2;
	}
	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	@Override
	public String toString() {
		return "DetailVo [movieNm=" + movieNm + ", showTm=" + showTm + ", openDt=" + openDt + ", director=" + director
				+ ", actor=" + actor + ", actor2=" + actor2 + ", cast=" + cast + "]";
	}
	
	
}
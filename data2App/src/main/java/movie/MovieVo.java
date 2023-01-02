package movie;

public class MovieVo {
	private int rnum;// 줄번호
	private int rank;// 순위
	private String movieCd;// 영화코드
	private String movieNm;// 제목
	private String openDt;// 개봉일
	private String audiAcc; // 누적관객수
	private String salesAcc; // 누적매출액

	public MovieVo() {
	}

	public MovieVo(int rnum, int rank, String movieCd, String movieNm, String openDt, String audiAcc, String salesAcc) {
		this.rnum = rnum;
		this.rank = rank;
		this.movieCd = movieCd;
		this.movieNm = movieNm;
		this.openDt = openDt;
		this.audiAcc = audiAcc;
		this.salesAcc = salesAcc;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getMovieCd() {
		return movieCd;
	}

	public void setMovieCd(String movieCd) {
		this.movieCd = movieCd;
	}

	public String getMovieNm() {
		return movieNm;
	}

	public void setMovieNm(String movieNm) {
		this.movieNm = movieNm;
	}

	public String getOpenDt() {
		return openDt;
	}

	public void setOpenDt(String openDt) {
		this.openDt = openDt;
	}

	public String getAudiAcc() {
		return audiAcc;
	}

	public void setAudiAcc(String audiAcc) {
		this.audiAcc = audiAcc;
	}

	public String getSalesAcc() {
		return salesAcc;
	}

	public void setSalesAcc(String salesAcc) {
		this.salesAcc = salesAcc;
	}

	@Override
	public String toString() {
		return "MovieVo [rnum=" + rnum + ", rank=" + rank + ", movieCd=" + movieCd + ", movieNm=" + movieNm
				+ ", openDt=" + openDt + ", audiAcc=" + audiAcc + ", salesAcc=" + salesAcc + "]";
	}

}

package bus;

public class BusVo {
	private String busRouteId; //노선id
	private String busRouteNm; //버스번호
	private String corpNm; //운수회사
	private String stStationNm; //기점
	private String edStationNm; //종점
	private String term; // 배차간격
	private String firstBusTm; //첫차시간
	private String lastBusTm; //막차시간
	
	public BusVo() {}
	
	public BusVo(String busRouteId, String busRouteNm, String corpNm, String stStationNm, String edStationNm, String term,
			String firstBusTm, String lastBusTm) {
	
		this.busRouteId = busRouteId;
		this.busRouteNm = busRouteNm;
		this.corpNm = corpNm;
		this.stStationNm = stStationNm;
		this.edStationNm = edStationNm;
		this.term = term;
		this.firstBusTm = firstBusTm;
		this.lastBusTm = lastBusTm;
	}

	public String getBusRouteId() {
		return busRouteId;
	}

	public void setBusRouteId(String busRouteId) {
		this.busRouteId = busRouteId;
	}

	public String getbusRouteNm() {
		return busRouteNm;
	}

	public void setbusRouteNm(String busRouteNm) {
		this.busRouteNm = busRouteNm;
	}

	public String getCorpNm() {
		return corpNm;
	}

	public void setCorpNm(String corpNm) {
		this.corpNm = corpNm;
	}

	public String getStStationNm() {
		return stStationNm;
	}

	public void setStStationNm(String stStationNm) {
		this.stStationNm = stStationNm;
	}

	public String getEdStationNm() {
		return edStationNm;
	}

	public void setEdStationNm(String edStationNm) {
		this.edStationNm = edStationNm;
	}

	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public String getFirstBusTm() {
		return firstBusTm;
	}

	public void setFirstBusTm(String firstBusTm) {
		this.firstBusTm = firstBusTm;
	}

	public String getLastBusTm() {
		return lastBusTm;
	}

	public void setLastBusTm(String lastBusTm) {
		this.lastBusTm = lastBusTm;
	}

	@Override
	public String toString() {
		return "BusVo [busRouteId=" + busRouteId + ", busRouteNm=" + busRouteNm + ", corpNm=" + corpNm + ", stStationNm="
				+ stStationNm + ", edStationNm=" + edStationNm + ", term=" + term + ", firstBusTm=" + firstBusTm
				+ ", lastBusTm=" + lastBusTm + "]";
	}
	
	
}

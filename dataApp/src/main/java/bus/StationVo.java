package bus;

public class StationVo {
	private String arsid;
	private String busRouteId;
	private String busRouteNm;
	private String stationNm;
	private String direction;
	public StationVo() {}
	
	public StationVo(String arsid, String busRouteId, String busRouteNm, String stationNm, String direction) {
		
		this.arsid = arsid;
		this.busRouteId = busRouteId;
		this.busRouteNm = busRouteNm;
		this.stationNm = stationNm;
		this.direction = direction;
	}
	public String getArsid() {
		return arsid;
	}

	public void setArsid(String arsid) {
		this.arsid = arsid;
	}

	public String getBusRouteId() {
		return busRouteId;
	}

	public void setBusRouteId(String busRouteId) {
		this.busRouteId = busRouteId;
	}

	public String getBusRouteNm() {
		return busRouteNm;
	}

	public void setBusRouteNm(String busRouteNm) {
		this.busRouteNm = busRouteNm;
	}

	public String getStationNm() {
		return stationNm;
	}

	public void setStationNm(String stationNm) {
		this.stationNm = stationNm;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "StationVo [arsid=" + arsid + ", busRouteId=" + busRouteId + ", busRouteNm=" + busRouteNm
				+ ", stationNm=" + stationNm + ", direction=" + direction + "]";
	}
	
}

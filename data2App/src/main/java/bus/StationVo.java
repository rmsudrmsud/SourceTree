package bus;

public class StationVo {
	private String arsId;
	private String busRouteId; 
	private String stationNm; 
	private String seq;
	private String direction; 
	private String gpsX; 
	private String gpsY;
	
	public StationVo() {
		
	}

	public StationVo(String arsId, String busRouteId, String stationNm, String seq, String direction, String gpsX, String gpsY) {
		this.arsId = arsId;
		this.busRouteId = busRouteId;
		this.stationNm = stationNm;
		this.seq = seq;
		this.direction = direction;
		this.gpsX = gpsX;
		this.gpsY = gpsY;
	}

	public String getArsId() {
		return arsId;
	}

	public void setArsId(String arsId) {
		this.arsId = arsId;
	}

	public String getBusRouteId() {
		return busRouteId;
	}

	public void setBusRouteId(String busRouteId) {
		this.busRouteId = busRouteId;
	}

	public String getStationNm() {
		return stationNm;
	}

	public void setStationNm(String stationNm) {
		this.stationNm = stationNm;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getGpsX() {
		return gpsX;
	}

	public void setGpsX(String gpsX) {
		this.gpsX = gpsX;
	}

	public String getGpsY() {
		return gpsY;
	}

	public void setGpsY(String gpsY) {
		this.gpsY = gpsY;
	}

	@Override
	public String toString() {
		return "StationVo [busRouteId=" + busRouteId + ", stationNm=" + stationNm + ", seq=" + seq + ", direction="
				+ direction + ", gpsX=" + gpsX + ", gpsY=" + gpsY + "]";
	}
	
}

public class SimpleDayInfo
{
	private String scheduleCode;
	private String scheduleKind;
	private String scheduleName;
	private int startHour;
	private int startMinutes;
	private int endHour;
	private int endMinutes;


	public SimpleDayInfo(){
	}
	public SimpleDayInfo(String scheduleCode, String scheduleKind, String scheduleName, int startHour, int startMinutes, int endHour, int endMinutes){
		this.scheduleCode = scheduleCode;
		this.scheduleKind = scheduleKind;
		this.scheduleName = scheduleName;
		this.startHour = startHour;
		this.startMinutes = startMinutes;
		this.endHour = endHour;
		this.endMinutes = endMinutes;
	}

	public void setScheduleCode(String scheduleCode){
		this.scheduleCode = scheduleCode;
	}
	public void setScheduleKind(String scheduleKind){
		this.scheduleKind = scheduleKind;
	}
	public void setScheduleName(String scheduleName){
		this.scheduleName = scheduleName;
	}
	public void setStartHour(int startHour){
		this.startHour = startHour;
	}
	public void setStartMinutes(int startMinutes){
		this.startMinutes = startMinutes;
	}
	public void setEndHour(int endHour){
		this.endHour = endHour;
	}
	public void setEndMinutes(int endMinutes){
		this.endMinutes = endMinutes;
	}
	public String getScheduleCode(){
		return this.scheduleCode;
	}
	public String getScheduleKind(){
		return this.scheduleKind;
	}
	public String getScheduleName(){
		return this.scheduleName;
	}
	public int getStartHour(){
		return this.startHour;
	}
	public int getStartMinutes(){
		return this.startMinutes;
	}
	public int getEndHour(){
		return this.endHour;
	}
	public int getEndMinutes(){
		return this.endMinutes;
	}




}

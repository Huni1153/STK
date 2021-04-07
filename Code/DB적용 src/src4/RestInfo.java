public class RestInfo
{
	private int dayScheduleTotalHour;
	private int dayScheduleTotalMinutes;
	private int restIndex;

	public RestInfo(){
		this.dayScheduleTotalHour = 0;
		this.dayScheduleTotalMinutes = 0;
		this.restIndex = 0;
	}

	public RestInfo(int dayScheduleTotalHour, int dayScheduleTotalMinutes){
		this.dayScheduleTotalHour = dayScheduleTotalHour;
		this.dayScheduleTotalMinutes = dayScheduleTotalMinutes;
		
		calcRestIndex(this.dayScheduleTotalHour, this.dayScheduleTotalMinutes);
	}
	public void setDayScheduleTotalHour(int dayScheduleTotalHour){
		this.dayScheduleTotalHour = dayScheduleTotalHour;
	}
	public void setDayScheduleTotalMinutes(int dayScheduleTotalMinutes){
		this.dayScheduleTotalMinutes = dayScheduleTotalMinutes;
	}
	public void setRestIndex(int restIndex){
		this.restIndex = restIndex;
	}
	public int getDayScheduleTotalHour(){
		return this.dayScheduleTotalHour;
	}
	public int getDayScheduleTotalMinutes(){
		return this.dayScheduleTotalMinutes;
	}
	public int getRestIndex(){
		return restIndex;
	}
	public void calcRestIndex(int hour, int minutes){
		if( (hour*60) + minutes < 360 ){
			this.restIndex = 1;
		}
		else if( (hour*60) + minutes >= 360 && (hour*60) + minutes < 480 ){
			this.restIndex = 2;
		}
		else if( (hour*60) + minutes >= 480 ){
			this.restIndex = 3;
		}

	}
	public int provideRestIndex(int hour, int minutes){
		calcRestIndex(hour, minutes);
		return getRestIndex();
	}






}
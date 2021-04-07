package Model;
public class RestInfoController
{
	private RestInfo restInfo;


	public RestInfoController(){
		this.restInfo = new RestInfo();
	}
	public RestInfoController(RestInfo restInfo){
		this.restInfo = restInfo;
	}
	public void setRestInfo(RestInfo restInfo){
		this.restInfo = restInfo;
	}
	public RestInfo getRestInfo(){
		return this.restInfo;
	}
	public int requestProvideRestIndex(int hour, int minutes){
		return restInfo.provideRestIndex(hour, minutes);
	}


}